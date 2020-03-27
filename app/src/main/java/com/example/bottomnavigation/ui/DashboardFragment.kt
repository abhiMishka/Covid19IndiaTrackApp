package com.example.bottomnavigation.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentDashboardBinding
import com.example.bottomnavigation.helper.UtilFunctions
import com.example.bottomnavigation.network.Repository
import com.example.bottomnavigation.network.dataclasses.AllDataResponse
import com.google.gson.Gson
import de.codecrafters.tableview.TableView
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DashboardFragment : Fragment() {


    var spaceProbes: Array<Array<String>> = Array(100) { Array(5) { "" } }

    val spaceProbeHeaders = arrayOf("State", "Confirmed", "Active", "Recovered", "Deaths")
    val adapter: SimpleTableDataAdapter? = null

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_dashboard)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            getAllData()
            doTableViewThings()
        }
    }

    fun doTableViewThings() {
        val tableView: TableView<Array<String>> = binding.tableView as TableView<Array<String>>

        val adapter = SimpleTableDataAdapter(activity, spaceProbes)
        tableView.apply {
            setHeaderBackgroundColor(Color.parseColor("#D3D3D3"))
            dataAdapter = adapter
            headerAdapter = SimpleTableHeaderAdapter(activity, *spaceProbeHeaders)
            setColumnCount(4)
        }
    }

    suspend fun getAllData() {
        val repo = Repository()
        val response = repo.getAllData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val allDataAResponse: AllDataResponse =
                    gson.fromJson(response.body(), AllDataResponse::class.java)

            var i = 0;
            for (state in allDataAResponse.statewise) {
                spaceProbes.set(i, arrayOf(state.state, state.confirmed, state.active, state.recovered, state.deaths))
                i += 1
            }
            adapter?.notifyDataSetChanged()
            Log.i("testApi", allDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    companion object {
        val TAG: String = DashboardFragment::class.java.simpleName
        fun newInstance() = DashboardFragment()
    }

}