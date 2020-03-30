package com.example.covid.network

import com.example.covid.Covid19IndiaTrackApplication

class Repository {
    var client  = Covid19IndiaTrackApplication.getRetrofitClient()?.create(HttpAPIService::class.java)

    suspend fun getStateWiseData() = client?.getStateWiseInfo()
    suspend fun getRawData() = client?.getRawData()
    suspend fun getTravelHistoryData() = client?.getTravelHistoryData()
    suspend fun getAllData() = client?.getAllData()


}