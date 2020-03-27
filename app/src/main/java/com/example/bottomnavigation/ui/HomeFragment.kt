package com.example.bottomnavigation.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentHomeBinding
import com.example.bottomnavigation.helper.UtilFunctions
import com.example.bottomnavigation.network.Repository
import com.example.bottomnavigation.network.dataclasses.AllDataResponse
import com.example.bottomnavigation.network.dataclasses.RawDataAResponse
import com.example.bottomnavigation.network.dataclasses.StateWiseResponse
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_home)
        return binding.root
    }

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        GlobalScope.launch(Dispatchers.Main) {
            getStateWiseData()
            getRawData()
            getAllData()
            setUpPieChartData()
            setupBarChartData()
        }
    }

    suspend fun getStateWiseData() {
        val repo = Repository()
        val response = repo.getStateWiseData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val stateWiseResponse: StateWiseResponse =
                    gson.fromJson(response.body(), StateWiseResponse::class.java)
            Log.i("testApi", stateWiseResponse.toString())
        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }


    suspend fun getAllData() {
        val repo = Repository()
        val response = repo.getAllData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val allDataAResponse: AllDataResponse =
                    gson.fromJson(response.body(), AllDataResponse::class.java)
            setupLineChartData(allDataAResponse)
            Log.i("testApi2", allDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }

    }

    suspend fun getRawData() {
        val repo = Repository()
        val response = repo.getRawData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            val rawDataAResponse: RawDataAResponse =
                    gson.fromJson(response.body(), RawDataAResponse::class.java)
            Log.i("testApi", rawDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    fun setUpPieChartData() {
        Log.i("testApi2", "inside setUpPieChartData")

        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(30f))
        yVals.add(PieEntry(2f))
        yVals.add(PieEntry(4f))
        yVals.add(PieEntry(22f))
        yVals.add(PieEntry(12.5f))

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize = 0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.GRAY)
        colors.add(Color.BLUE)
        colors.add(Color.RED)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)

        dataSet.setColors(colors)
        val data = PieData(dataSet)
        binding.pieChart.data = data
        binding.pieChart.centerTextRadiusPercent = 0f
        binding.pieChart.isDrawHoleEnabled = false
        binding.pieChart.legend.isEnabled = false
        binding.pieChart.description.isEnabled = false
    }

    fun setupLineChartData(allDataAResponse: AllDataResponse) {
        val yVals = ArrayList<Entry>()
        var i = 0
//        val xAxisValues: ArrayList<String> = ArrayList()

        for (case in allDataAResponse.casesTimeSeries) {
//                xAxisValues.add(case.date)

            yVals.add(Entry(i.toFloat(), case.totalconfirmed.toFloat(), case))
            Log.i("testApi", "case : " + case)
            i++
        }

//        yVals.add(Entry(0f, 30f, "0"))
//        yVals.add(Entry(1f, 2f, "1"))
//        yVals.add(Entry(2f, 4f, "2"))
//        yVals.add(Entry(3f, 6f, "3"))
//        yVals.add(Entry(4f, 8f, "4"))
//        yVals.add(Entry(5f, 10f, "5"))
//        yVals.add(Entry(6f, 22f, "6"))
//        yVals.add(Entry(7f, 12.5f, "7"))
//        yVals.add(Entry(8f, 22f, "8"))
//        yVals.add(Entry(9f, 32f, "9"))
//        yVals.add(Entry(10f, 54f, "10"))
//        yVals.add(Entry(11f, 28f, "11"))

        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        // set1.fillAlpha = 110
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        // set1.enableDashedLine(5f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.color = Color.BLUE
        set1.setCircleColor(Color.BLUE)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 0f
        set1.setDrawFilled(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        // set data
        binding.lineChart.setData(data)
        binding.lineChart.description.isEnabled = false
        binding.lineChart.legend.isEnabled = false
        binding.lineChart.setPinchZoom(true)
        binding.lineChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        binding.lineChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        binding.lineChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        //lineChart.setDrawGridBackground()
//        binding.lineChart.xAxis.labelCount = xAxisValues.size
//        binding.lineChart.xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValues))

        binding.lineChart.xAxis.position = XAxis.XAxisPosition.BOTH_SIDED
        binding.lineChart.notifyDataSetChanged()
    }

    private fun setupBarChartData() {
        // create BarEntry for Bar Group
        val bargroup = ArrayList<BarEntry>()
        bargroup.add(BarEntry(0f, 30f, "0"))
        bargroup.add(BarEntry(1f, 2f, "1"))
        bargroup.add(BarEntry(2f, 4f, "2"))
        bargroup.add(BarEntry(3f, 6f, "3"))
        bargroup.add(BarEntry(4f, 8f, "4"))
        bargroup.add(BarEntry(5f, 10f, "5"))
        bargroup.add(BarEntry(6f, 22f, "6"))
        bargroup.add(BarEntry(7f, 12.5f, "7"))
        bargroup.add(BarEntry(8f, 22f, "8"))
        bargroup.add(BarEntry(9f, 32f, "9"))
        bargroup.add(BarEntry(10f, 54f, "10"))
        bargroup.add(BarEntry(11f, 28f, "11"))

        // creating dataset for Bar Group
        val barDataSet = BarDataSet(bargroup, "")

        barDataSet.color = ContextCompat.getColor(context!!, R.color.amber)

        val data = BarData(barDataSet)
        binding.barChart.apply {
            setData(data)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.labelCount = 11
            xAxis.enableGridDashedLine(5f, 5f, 0f)
            axisRight.enableGridDashedLine(5f, 5f, 0f)
            axisLeft.enableGridDashedLine(5f, 5f, 0f)
            description.isEnabled = false
            animateY(1000)
            legend.isEnabled = false
            setPinchZoom(true)
            data.setDrawValues(false)
        }

    }

}