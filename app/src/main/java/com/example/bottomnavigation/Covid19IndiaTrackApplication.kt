package com.example.bottomnavigation

import android.app.Application
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class Covid19IndiaTrackApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        const val BASE_URL = "https://api.covid19india.org/"
        var okhttpClient: OkHttpClient? = null
        private var retrofit: Retrofit? = null
        private lateinit var instance: Covid19IndiaTrackApplication

        fun getInstance(): Covid19IndiaTrackApplication {
            return instance
        }

        fun getRetrofitClient(): Retrofit? {
            val okHttpClient = getOkHttpClient() ?: return null
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL) //BASE_URL
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

        fun getOkHttpClient(): OkHttpClient? {
            if (okhttpClient == null) {
                okhttpClient = OkHttpClient.Builder()
                        .addInterceptor(ResponseInterceptor()).build()
            }
            return okhttpClient

        }

        private class ResponseInterceptor : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val original = chain.request()
                val builder = original.newBuilder().method(original.method(), original.body())
                val response = chain.proceed(builder.build())
                val contentType = response.body()?.contentType()
                val responseBody = ResponseBody.create(contentType, response.body()?.string() ?: "")
                return response.newBuilder().body(responseBody).build()

            }
        }
    }
}