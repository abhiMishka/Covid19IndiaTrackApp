package com.example.bottomnavigation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentStateWiseBinding
import com.example.bottomnavigation.helper.UtilFunctions
import com.example.bottomnavigation.network.Repository
import com.example.bottomnavigation.network.dataclasses.AllDataResponse
import com.google.gson.Gson
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import kotlinx.android.synthetic.main.fragment_state_wise.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface ItemSelectListener {
    fun onItemClick(stateWiseData: AllDataResponse.Statewise, clickPosition: Int)
}

class StateWiseFragment : Fragment() {

    var spaceProbes: Array<Array<String>> = Array(100) { Array(5) { "" } }

    val spaceProbeHeaders = arrayOf("State", "Confirmed", "Active", "Recovered", "Deaths")
    val adapter: SimpleTableDataAdapter? = null

    private lateinit var binding: FragmentStateWiseBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStateWiseBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_states_stats)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)




        GlobalScope.launch(Dispatchers.Main) {
            getAllData()
//            doTableViewThings()
        }
    }

    private fun initPaymentModeAdapter(recycleView: RecyclerView?, conFeeResponse: List<AllDataResponse.Statewise>) {
        val stateWiseAdapter = StateWiseAdapter(conFeeResponse, itemClickListener)
        val layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        recycleView?.layoutManager = layoutManager
        recycleView?.adapter = stateWiseAdapter
    }

    val itemClickListener = object : ItemSelectListener {
        override fun onItemClick(stateWiseData: AllDataResponse.Statewise, clickPosition: Int) {
//            Toaster.showMessageShort(convenienceFeeResponse.toString())
        }
    }

    fun doTableViewThings() {
//        val tableView: TableView<Array<String>> = binding.tableView as TableView<Array<String>>
//
//        val adapter = SimpleTableDataAdapter(activity, spaceProbes)
//        tableView.apply {
//            setHeaderBackgroundColor(Color.parseColor("#D3D3D3"))
//            dataAdapter = adapter
//            headerAdapter = SimpleTableHeaderAdapter(activity, *spaceProbeHeaders)
//            setColumnCount(4)
//        }
    }

    suspend fun getAllData() {
        val repo = Repository()
        val response = repo.getAllData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val allDataAResponse: AllDataResponse =
                    gson.fromJson(response.body(), AllDataResponse::class.java)

            initPaymentModeAdapter(stateWiseRv,allDataAResponse.statewise)
//            var i = 0;
//            for (state in allDataAResponse.statewise) {
//                spaceProbes.set(i, arrayOf(state.state, state.confirmed, state.active, state.recovered, state.deaths))
//                i += 1
//            }
//            adapter?.notifyDataSetChanged()
            Log.i("testApi", allDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    companion object {
        val TAG: String = StateWiseFragment::class.java.simpleName
        fun newInstance() = StateWiseFragment()
    }

}