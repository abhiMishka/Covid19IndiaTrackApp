package com.example.covid.network

import com.google.gson.JsonElement
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HttpAPIService {

    @GET(HttpConstants.STATE_DISTRICT_WISE)
    suspend fun getStateWiseInfo(): Response<JsonElement>

    @GET(HttpConstants.RAW_DATA)
    suspend fun getRawData(): Response<JsonElement>

    @GET(HttpConstants.TRAVEL_HOSTORY_DATA)
    suspend fun getTravelHistoryData(): Response<JsonElement>

    @GET(HttpConstants.ALL_DATA)
    suspend fun getAllData(): Response<JsonElement>

}