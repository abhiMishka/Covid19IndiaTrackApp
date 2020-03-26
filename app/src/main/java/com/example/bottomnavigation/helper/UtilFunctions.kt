package com.example.bottomnavigation.helper

import android.widget.Toast
import com.example.bottomnavigation.Covid19IndiaTrackApplication

class UtilFunctions {
    companion object{
        fun toast(message : String){
            Toast.makeText(Covid19IndiaTrackApplication.getInstance(),message,Toast.LENGTH_SHORT).show()
        }
    }
}