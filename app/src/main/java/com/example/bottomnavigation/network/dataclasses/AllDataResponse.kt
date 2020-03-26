package com.example.bottomnavigation.network.dataclasses


import com.google.gson.annotations.SerializedName

data class AllDataResponse(
    @SerializedName("cases_time_series")
    val casesTimeSeries: List<CasesTimeSery>,
    @SerializedName("key_values")
    val keyValues: List<KeyValue>,
    @SerializedName("statewise")
    val statewise: List<Statewise>,
    @SerializedName("tested")
    val tested: List<Tested>
) {
    data class CasesTimeSery(
        @SerializedName("dailyconfirmed")
        val dailyconfirmed: String,
        @SerializedName("dailydeceased")
        val dailydeceased: String,
        @SerializedName("dailyrecovered")
        val dailyrecovered: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("totalconfirmed")
        val totalconfirmed: String,
        @SerializedName("totaldeceased")
        val totaldeceased: String,
        @SerializedName("totalrecovered")
        val totalrecovered: String
    )

    data class KeyValue(
        @SerializedName("confirmeddelta")
        val confirmeddelta: String,
        @SerializedName("counterforautotimeupdate")
        val counterforautotimeupdate: String,
        @SerializedName("deceaseddelta")
        val deceaseddelta: String,
        @SerializedName("lastupdatedtime")
        val lastupdatedtime: String,
        @SerializedName("recovereddelta")
        val recovereddelta: String,
        @SerializedName("statesdelta")
        val statesdelta: String
    )

    data class Statewise(
        @SerializedName("active")
        val active: String,
        @SerializedName("confirmed")
        val confirmed: String,
        @SerializedName("deaths")
        val deaths: String,
        @SerializedName("delta")
        val delta: Delta,
        @SerializedName("lastupdatedtime")
        val lastupdatedtime: String,
        @SerializedName("recovered")
        val recovered: String,
        @SerializedName("state")
        val state: String
    ) {
        data class Delta(
            @SerializedName("active")
            val active: Int,
            @SerializedName("confirmed")
            val confirmed: Int,
            @SerializedName("deaths")
            val deaths: Int,
            @SerializedName("recovered")
            val recovered: Int
        )
    }

    data class Tested(
        @SerializedName("source")
        val source: String,
        @SerializedName("totalindividualstested")
        val totalindividualstested: String,
        @SerializedName("totalpositivecases")
        val totalpositivecases: String,
        @SerializedName("totalsamplestested")
        val totalsamplestested: String,
        @SerializedName("updatetimestamp")
        val updatetimestamp: String
    )
}