package com.example.bottomnavigation.helper

import android.content.Context
import android.widget.TextView
import com.example.bottomnavigation.R
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



/**
 * Created by Shivarpit
 */
class GraphMarker(context: Context?,layout : Int,val yvals:ArrayList<Entry>) : MarkerView(context,layout){
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        val valueTv = findViewById<TextView>(R.id.value_tv)
        valueTv.text = "Cases:${e?.y?.toInt()}"
        setOffset(-(width).toFloat(),-height.toFloat())
    }
}