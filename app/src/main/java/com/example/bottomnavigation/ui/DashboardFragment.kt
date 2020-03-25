package com.example.bottomnavigation.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentDashboardBinding
import de.codecrafters.tableview.TableView
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter


class DashboardFragment : Fragment() {

    var spaceProbes = arrayOf(
            arrayOf("Maharashtra", "122", "119", "1", "2"),
            arrayOf("Kerala", "118", "114", "4", "-"),
            arrayOf("Karnataka", "51", "47", "3", "1"),
            arrayOf("Telangana", "41", "40", "1", "-"),
            arrayOf("Gujarat", "38", "37", "-", "1"),
            arrayOf("U.P", "38", "27", "11", "-")
    )

    val spaceProbeHeaders = arrayOf("State", "Confirmed", "Active", "Recovered", "Deathss")


    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_dashboard)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        doTableViewThings()
    }

    fun doTableViewThings() {
        val tableView: TableView<Array<String>> = binding.tableView as TableView<Array<String>>

        tableView.apply {
            setHeaderBackgroundColor(Color.parseColor("#D3D3D3"))
            setDataAdapter(SimpleTableDataAdapter(activity, spaceProbes))
            setHeaderAdapter(SimpleTableHeaderAdapter(activity, *spaceProbeHeaders))
            setColumnCount(4)
        }
    }

    companion object {
        val TAG: String = DashboardFragment::class.java.simpleName
        fun newInstance() = DashboardFragment()
    }

}