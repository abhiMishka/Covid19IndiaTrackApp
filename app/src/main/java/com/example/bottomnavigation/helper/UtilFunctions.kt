package com.example.bottomnavigation.helper

import android.widget.Toast
import androidx.core.util.Preconditions
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

        fun getThFormatTime(time: Long): String {
            var finalString: String
            val date = Date(time)
            val n = date.date
            val suffix: String

            Preconditions.checkArgument(n in 1..31, "illegal day o2f month: $n")
            suffix = if (n in 11..19) {
                "th"
            } else {
                when (n % 10) {
                    1 -> "st"
                    2 -> "nd"
                    3 -> "rd"
                    else -> "th"
                }
            }
            finalString = n.toString() + suffix
            val format = SimpleDateFormat(" MMM yyyy")

            finalString += format.format(Date(time))
            return finalString
        }

        fun getTime(time: Long):String{
            val format = SimpleDateFormat("hh:mm a", Locale.UK)
            return format.format(Date(time))
        }
    }
}