package com.example.bottomnavigation.network.dataclasses


import com.google.gson.annotations.SerializedName

data class RawDataAResponse(
    @SerializedName("raw_data")
    val rawData: List<RawData>
) {
    data class RawData(
        @SerializedName("agebracket")
        val agebracket: String,
        @SerializedName("backupnotes")
        val backupnotes: String,
        @SerializedName("contractedfromwhichpatientsuspected")
        val contractedfromwhichpatientsuspected: String,
        @SerializedName("currentstatus")
        val currentstatus: String,
        @SerializedName("dateannounced")
        val dateannounced: String,
        @SerializedName("detectedcity")
        val detectedcity: String,
        @SerializedName("detecteddistrict")
        val detecteddistrict: String,
        @SerializedName("detectedstate")
        val detectedstate: String,
        @SerializedName("estimatedonsetdate")
        val estimatedonsetdate: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("nationality")
        val nationality: String,
        @SerializedName("notes")
        val notes: String,
        @SerializedName("patientnumber")
        val patientnumber: String,
        @SerializedName("source1")
        val source1: String,
        @SerializedName("source2")
        val source2: String,
        @SerializedName("source3")
        val source3: String,
        @SerializedName("statepatientnumber")
        val statepatientnumber: String,
        @SerializedName("statuschangedate")
        val statuschangedate: String
    )
}