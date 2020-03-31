package com.example.covid.network

import android.util.Log
import com.example.covid.helper.UtilFunctions
import com.example.covid.network.dataclasses.AllDataResponse
import com.example.covid.network.dataclasses.RawDataAResponse
import com.example.covid.network.dataclasses.StateWiseResponse
import com.example.covid.network.dataclasses.TravelHistoryResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

object DataManager {

    internal var stateWiseResponse: StateWiseResponse? = null
        get() = field
    internal var allDataAResponse: AllDataResponse? = null
        get() = field
    internal var rawDataAResponse: RawDataAResponse? = null
        get() = field
    internal var travelHistoryResponse: TravelHistoryResponse? = null
        get() = field
    private val repo = Repository()
    private val gson = Gson()

    private suspend fun getStateWiseData() {
        val response = repo.getStateWiseData()
        if (response?.isSuccessful == true) {
            stateWiseResponse = gson.fromJson(response.body(), StateWiseResponse::class.java)
            Log.i("testApi3", stateWiseResponse.toString())
        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }


    private suspend fun getAllData() {
        val response = repo.getAllData()
        if (response?.isSuccessful == true) {
            allDataAResponse =
                    gson.fromJson(response.body(), AllDataResponse::class.java)
            Log.i("testApi3", allDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }

    }

    private suspend fun getRawData() {
        val response = repo.getRawData()

        if (response?.isSuccessful == true) {
            rawDataAResponse = gson.fromJson(response.body(), RawDataAResponse::class.java)
            Log.i("testApi3", rawDataAResponse.toString())

        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    private suspend fun getTravelHistoryData() {

        val response = repo.getTravelHistoryData()

        if (response?.isSuccessful == true) {
            val gson = Gson()
            travelHistoryResponse = gson.fromJson(response.body(), TravelHistoryResponse::class.java)
            Log.i("testApi3", travelHistoryResponse.toString())

            for (travelHistory in travelHistoryResponse?.travelHistory!!) {
                val latLong = travelHistory.latlong
                val arr = latLong.split(",")
                if (arr.size > 1) {
                    val lat: Double = arr[0].toDouble()
                    val lng: Double = arr[1].toDouble()
                }
            }
        } else {
            UtilFunctions.toast(response?.errorBody()?.string() ?: "Error")
        }
        print(response.toString())
    }

    suspend fun syncData() = coroutineScope {
        awaitAll(async {
            getAllData()
        }, async {
            getStateWiseData()
        }, async {
            getTravelHistoryData()
        }, async {
            getRawData()
        })
        Log.i("testApi3", "add data fetched")

    }

}