package com.example.bottomnavigation.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.anychart.graphics.vector.SolidFill
import com.anychart.graphics.vector.Fill
import com.anychart.chart.common.dataentry.SingleValueDataSet
import com.anychart.AnyChart
import com.anychart.charts.CircularGauge
import com.anychart.enums.Anchor
import com.anychart.graphics.vector.text.HAlign
import com.anychart.graphics.vector.text.VAlign


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
        binding.circularGaugeProgress.visibility = View.VISIBLE
        val response = repo.getAllData()
        if (response?.isSuccessful == true) {
            val gson = Gson()
            val allDataAResponse: AllDataResponse =
                    gson.fromJson(response.body(), AllDataResponse::class.java)
            setupLineChartData(allDataAResponse)
            setupGaugeChartData(allDataAResponse)
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

    private fun setupGaugeChartData(allDataAResponse: AllDataResponse) {
        if (!allDataAResponse.statewise.isNullOrEmpty()) {
            binding.circularGaugeProgress.visibility = View.GONE
            binding.circularGaugeChart.visibility = View.VISIBLE
            val stateList = allDataAResponse.statewise[0]
            val circularGauge = AnyChart.circular()
            circularGauge.tooltip(false)
            circularGauge.credits(false)
            val maxRangeOfChart = stateList.confirmed.toInt().times(1.2)

            circularGauge.data(SingleValueDataSet(arrayOf(stateList.confirmed
                    , stateList.active
                    , stateList.deaths
                    , stateList.recovered
                    , maxRangeOfChart
                    , maxRangeOfChart)))

            circularGauge.fill("#fff")
                    .stroke(null)
                    .padding(0.0, 0.0, 0.0, 0.0)
                    .margin(100.0, 100.0, 100.0, 100.0)
            circularGauge.startAngle(0.0)
            circularGauge.sweepAngle(270.0)

            val xAxis = circularGauge.axis(0)
                    .radius(100.0)
                    .width(1.0)
                    .fill(null as Fill?)
            xAxis.scale()
                    .minimum(0.0)
                    .maximum(1000.0)
            xAxis.ticks("{ interval: 1 }")
                    .minorTicks("{ interval: 1 }")
            xAxis.labels().enabled(false)
            xAxis.ticks().enabled(false)
            xAxis.minorTicks().enabled(false)

            setCircularGauge(circularGauge
                    , 0.0.toFloat()
                    , "Total Cases (${stateList.confirmed})"
                    , "${100.0}%"
                    , 100.0.toFloat()
                    , "#64b5f6"
                    , 100.0.toFloat())

            setCircularGauge(circularGauge
                    , 1.0.toFloat()
                    , "Active Cases(${stateList.active})"
                    , "${80.0}%"
                    , 80.0.toFloat()
                    , "#1976d2"
                    , 101.0.toFloat())

            setCircularGauge(circularGauge, 2.0.toFloat()
                    , "Total Deaths(${stateList.deaths})"
                    , "${60.0}%"
                    , 60.0.toFloat()
                    , "#ef6c00"
                    , 102.0.toFloat())

            setCircularGauge(circularGauge, 3.0.toFloat()
                    , "Recovered Cases(${stateList.recovered})"
                    , "${40.0}%"
                    , 40.0.toFloat()
                    , "#ffd54f"
                    , 103.0.toFloat())
            circularGauge.margin(50.0, 50.0, 50.0, 50.0)
            binding.circularGaugeChart.setChart(circularGauge)
        } else {
            binding.circularGaugeChart.visibility = View.GONE
            Toast.makeText(context,"Not Able to Draw Graph",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setCircularGauge(circularGauge: CircularGauge
                                 , bar1LableIndex: Float
                                 , title: String
                                 , offsetY: String
                                 , radius: Float
                                 , color: String
                                 , bar2LableIndex: Float) {

        circularGauge.label(bar1LableIndex)
                .text(title)
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE)
        circularGauge.label(bar1LableIndex)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0.0, 10.0, 0.0, 0.0)
                .height("${(17.0 / 2.0)}%")
                .offsetY(offsetY)
                .offsetX(0.0)
        val bar3 = circularGauge.bar(bar1LableIndex)
        bar3.dataIndex(bar1LableIndex)
        bar3.radius(radius)
        bar3.width(17.0)
        bar3.fill(SolidFill(color, 1.0))
        bar3.stroke(null)
        bar3.zIndex(5.0)
        val bar103 = circularGauge.bar(bar2LableIndex)
        bar103.dataIndex(5.0)
        bar103.radius(radius)
        bar103.width(17.0)
        bar103.fill(SolidFill("#F5F4F4", 1.0))
        bar103.stroke("1 #e5e4e4")
        bar103.zIndex(4.0)
    }

}