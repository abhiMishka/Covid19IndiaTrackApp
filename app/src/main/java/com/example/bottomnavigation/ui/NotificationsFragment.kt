package com.example.bottomnavigation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentNotificationsBinding
import com.example.bottomnavigation.helper.UtilFunctions
import com.example.bottomnavigation.network.Repository
import com.example.bottomnavigation.network.dataclasses.TravelHistoryResponse
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class NotificationsFragment : Fragment(), OnMapReadyCallback {

    private var binding: FragmentNotificationsBinding? = null
    var mapFragment: MapFragment? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (binding == null) {
            binding = FragmentNotificationsBinding.inflate(inflater, container, false)
            activity?.title = getString(R.string.title_notifications)
            if (mapFragment == null) {
                mapFragment = activity?.fragmentManager?.findFragmentById(R.id.map) as MapFragment
                mapFragment?.getMapAsync(this)
            }
        }
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    companion object {
        val TAG: String = NotificationsFragment::class.java.simpleName
        fun newInstance() = NotificationsFragment()
    }

    override fun onMapReady(map: GoogleMap?) {

        GlobalScope.launch(Dispatchers.Main) {
            getTravelHistoryData(map)
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
            Log.i("testMap", "map is ready : travelHistoryResponse.travelHistory.size : " +travelHistoryResponse.travelHistory.size)
            for (travelHistory in travelHistoryResponse.travelHistory){
                val latLong = travelHistory.latlong
                val arr = latLong.split(",")
                if(arr.size>1) {
                    val lat : Double = arr[0].toDouble()
                    val lng : Double = arr[1].toDouble()
                    map?.addMarker(
                            MarkerOptions()
                                    .position(LatLng(lat,lng))
                                    .title(travelHistory.address))
                }
            }


        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

}