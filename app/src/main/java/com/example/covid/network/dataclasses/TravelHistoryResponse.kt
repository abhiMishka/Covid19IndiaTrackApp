package com.example.covid.network.dataclasses


import com.google.gson.annotations.SerializedName

data class TravelHistoryResponse(
    @SerializedName("travel_history")
    val travelHistory: List<TravelHistory>
) {
    data class TravelHistory(
        @SerializedName("accuracylocation")
        val accuracylocation: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("_cn6ca")
        val cn6ca: String,
        @SerializedName("_d2mkx")
        val d2mkx: String,
        @SerializedName("datasource")
        val datasource: String,
        @SerializedName("latlong")
        val latlong: String,
        @SerializedName("modeoftravel")
        val modeoftravel: String,
        @SerializedName("pid")
        val pid: String,
        @SerializedName("placename")
        val placename: String,
        @SerializedName("timefrom")
        val timefrom: String,
        @SerializedName("timeto")
        val timeto: String,
        @SerializedName("type")
        val type: String
    )
}