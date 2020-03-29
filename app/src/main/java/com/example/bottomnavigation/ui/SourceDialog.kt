package com.example.bottomnavigation.ui

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.example.bottomnavigation.R

/**
 * Created by Shivarpit
 */
class SourceDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.dialog_source, LinearLayout(activity), false)
        view.findViewById<ImageView>(R.id.close_dialog).setOnClickListener {
            dismiss()
        }
        val builder = Dialog(view.context)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCanceledOnTouchOutside(false)
        builder.setContentView(view!!)
        builder.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return builder
    }
}