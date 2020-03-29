package com.example.bottomnavigation.helper

import android.widget.Toast
import com.example.bottomnavigation.Covid19IndiaTrackApplication
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class UtilFunctions {
    companion object {
        fun toast(message: String) {
            Toast.makeText(Covid19IndiaTrackApplication.getInstance(), message, Toast.LENGTH_SHORT).show()
        }

        fun converDateFormat(date: String): String {

            val date = SimpleDateFormat("dd MMMM", Locale.UK).parse(date.trim())
            val sdf = SimpleDateFormat("dd MMM", Locale.UK)
            return sdf.format(date)
        }
    }
}