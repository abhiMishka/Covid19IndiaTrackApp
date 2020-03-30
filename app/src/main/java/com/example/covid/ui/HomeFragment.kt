package com.example.covid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.anychart.APIlib
import com.example.covid.R
import com.example.covid.databinding.FragmentHomeBinding
import com.example.covid.helper.UtilFunctions
import com.example.covid.network.dataclasses.AllDataResponse
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.anychart.graphics.vector.SolidFill
import com.anychart.graphics.vector.Fill
import com.anychart.chart.common.dataentry.SingleValueDataSet
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.CircularGauge
import com.anychart.enums.Anchor
import com.anychart.graphics.vector.text.HAlign
import com.anychart.graphics.vector.text.VAlign
import com.example.covid.helper.GraphMarker
import com.example.covid.network.DataManager
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_national_stats)
        (activity as MainActivity?)?.enableSwipe()

        return binding.root
    }

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        drawCharts()
    }

    fun drawCharts() {
        binding.circularGaugeProgress.visibility = View.VISIBLE
        val allDataAResponse: AllDataResponse? = DataManager.allDataAResponse
        allDataAResponse?.let {
            val time = System.currentTimeMillis()
            setCumulativeData(allDataAResponse)
            setUpLineChartData(allDataAResponse)
            setupGaugeChartData(allDataAResponse,time)
        }

    }

    private fun setCumulativeData(allDataAResponse: AllDataResponse) {
        if (!allDataAResponse.statewise.isNullOrEmpty()) {
            val cumulativeData = allDataAResponse.statewise[0]
            binding.activeCount.text = cumulativeData.active
            binding.deathCount.text = cumulativeData.deaths
            binding.totalCasesCount.text = cumulativeData.confirmed
            binding.recoveredCount.text = cumulativeData.recovered
        } else {
            binding.activeCount.text = getString(R.string.not_known)
            binding.deathCount.text = getString(R.string.not_known)
            binding.totalCasesCount.text = getString(R.string.not_known)
            binding.recoveredCount.text = getString(R.string.not_known)
        }
    }

    private fun setUpLineChartData(allDataAResponse: AllDataResponse) {
        setupLineTotalChartData(allDataAResponse)
        setupLineTotalRecoveredData(allDataAResponse)
        setUpLineTotalDeathData(allDataAResponse)
    }

    private fun setUpLineTotalDeathData(allDataAResponse: AllDataResponse) {
        val yVals = ArrayList<Entry>()
        val xVals = ArrayList<String>()
        for ((i, case) in allDataAResponse.casesTimeSeries.withIndex()) {
            xVals.add(UtilFunctions.converDateFormat(case.date))
            yVals.add(Entry(i.toFloat(), case.totaldeceased.toFloat(), case))
        }

        createGraph(binding.lineChartdeath, resources.getColor(R.color.red), yVals, "Total Death", xVals)
    }

    private fun setupLineTotalRecoveredData(allDataAResponse: AllDataResponse) {
        val yVals = ArrayList<Entry>()
        val xVals = ArrayList<String>()
        for ((i, case) in allDataAResponse.casesTimeSeries.withIndex()) {
            xVals.add(UtilFunctions.converDateFormat(case.date))
            yVals.add(Entry(i.toFloat(), case.totalrecovered.toFloat(), case))
        }
        createGraph(binding.lineChartrecovered, resources.getColor(R.color.primary), yVals, "Total Recovered", xVals)
    }

    private fun setupLineTotalChartData(allDataAResponse: AllDataResponse) {
        val yVals = ArrayList<Entry>()
        val xVals = ArrayList<String>()
        for ((i, case) in allDataAResponse.casesTimeSeries.withIndex()) {
            xVals.add(UtilFunctions.converDateFormat(case.date))
            yVals.add(Entry(i.toFloat(), case.totalconfirmed.toFloat(), case))
        }
        createGraph(binding.lineChart, resources.getColor(R.color.blue_pale), yVals, "Total Confirmed", xVals)
    }

    private fun createGraph(view: LineChart, color: Int, yVals: ArrayList<Entry>, dataSet: String, xVals: ArrayList<String>) {

        val set1 = LineDataSet(yVals, dataSet)
        set1.color = color
        set1.setCircleColor(color)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 0f
        set1.setDrawFilled(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)
        view.data = data
        view.invalidate()
        view.setTouchEnabled(true)
        view.description.isEnabled = false
        view.legend.isEnabled = false
        view.setScaleEnabled(true)
        view.isClickable = false
        view.setPinchZoom(true)
        view.axisLeft.setDrawGridLines(false)
        view.xAxis.setDrawGridLines(false)
        val yAxisRight = view.axisRight
        yAxisRight.isEnabled = false
        view.xAxis.valueFormatter = IndexAxisValueFormatter(xVals)
        view.xAxis.position = XAxis.XAxisPosition.BOTTOM
        val marker = GraphMarker(context, R.layout.marker_item, yVals)
        view.marker = marker
        view.notifyDataSetChanged()
    }

    private fun setupGaugeChartData(allDataAResponse: AllDataResponse, time:Long) {
        if (!allDataAResponse.statewise.isNullOrEmpty()) {
            binding.circularGaugeChart.visibility = View.VISIBLE
            binding.lastUpdatedTime.visibility = View.VISIBLE
            binding.circularGaugeChart.animation = AnimationUtils.loadAnimation(context,
                    R.anim.fade_in_animation)
            binding.lastUpdatedTime.text = String.format("*Last Updated : %s %s",UtilFunctions.getThFormatTime(time),UtilFunctions.getTime(time))
            APIlib.getInstance().setActiveAnyChartView(binding.circularGaugeChart)
            val stateList = allDataAResponse.statewise[0]
            val circularGauge = AnyChart.circular()
            circularGauge.tooltip(false)
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
                    .maximum(maxRangeOfChart)
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
            binding.circularGaugeChart.animate()
        } else {
            binding.circularGaugeChart.visibility = View.GONE
            binding.lastUpdatedTime.visibility = View.GONE
            UtilFunctions.toast("Not able to draw graph")
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

    override fun onDataRefreshed() {
        drawCharts()
    }

}

private class CustomDataEntry(x: String, value: Number) : ValueDataEntry(x, value)

