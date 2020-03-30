package com.example.covid.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.covid.R
import com.example.covid.databinding.FragmentNotificationsBinding
import com.example.covid.helper.UtilFunctions
import com.example.covid.network.Repository
import com.example.covid.network.dataclasses.TravelHistoryResponse
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.layout_loading.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class TravelHistoryFragment : BaseFragment(), OnMapReadyCallback, AdvancedWebView.Listener {

    private var binding: FragmentNotificationsBinding? = null
    var pageFinished = false
    //    var mapFragment: MapFragment? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as MainActivity?)?.disableSwipe()

        if (binding == null) {
            binding = FragmentNotificationsBinding.inflate(inflater, container, false)
            binding?.webview?.setListener(activity, this)
            binding?.webview?.isNestedScrollingEnabled = false

//                mapFragment = activity?.fragmentManager?.findFragmentById(R.id.map) as MapFragment
//                mapFragment?.getMapAsync(this)
//            }
        }
        activity?.title = getString(R.string.title_map)

        if (!pageFinished) {
            binding?.webview?.loadUrl("https://www.bing.com/covid")
        }

        return binding?.root
    }


    override fun onDataRefreshed() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() { // Handle the back button event
                if (webview.canGoBack()) {
                    webview.goBack()
                } else {
                    activity?.finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        val TAG: String = TravelHistoryFragment::class.java.simpleName
        fun newInstance() = TravelHistoryFragment()
    }

    override fun onMapReady(map: GoogleMap?) {

        GlobalScope.launch(Dispatchers.Main) {
            //            getTravelHistoryData(map)
        }

    }

    suspend fun getTravelHistoryData(map: GoogleMap?) {
        val center = CameraUpdateFactory.newLatLng(LatLng(28.7041,
                77.1025))
        val zoom = CameraUpdateFactory.zoomTo(5f)

        val repo = Repository()
        val response = repo.getTravelHistoryData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val travelHistoryResponse: TravelHistoryResponse =
                    gson.fromJson(response.body(), TravelHistoryResponse::class.java)

            map!!.moveCamera(center)
            map.animateCamera(zoom)
            Log.i("testMap", "map is ready : travelHistoryResponse.travelHistory.size : " + travelHistoryResponse.travelHistory.size)
            for (travelHistory in travelHistoryResponse.travelHistory) {
                val latLong = travelHistory.latlong
                val arr = latLong.split(",")
                if (arr.size > 1) {
                    val lat: Double = arr[0].toDouble()
                    val lng: Double = arr[1].toDouble()
                    map.addMarker(
                            MarkerOptions()
                                    .position(LatLng(lat, lng))
                                    .title(travelHistory.address))
                }
            }


        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    override fun onPageFinished(url: String?) {
        Log.i("testWeb", "onPageFinished")

        loadingLl?.let {
            (activity as BaseActivity)?.rotate?.pause()
            it.visibility = View.GONE
            pageFinished = true
        }
        webview?.visibility = View.VISIBLE
    }


    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
    }

    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long, contentDisposition: String?, userAgent: String?) {
    }

    override fun onExternalPageRequest(url: String?) {
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        Log.i("testWeb", "onPageStareted")
        loadingLl.visibility = View.VISIBLE
        webview.visibility = View.GONE
        (activity as BaseActivity).rotateClockwise(appIconIv)
    }


}