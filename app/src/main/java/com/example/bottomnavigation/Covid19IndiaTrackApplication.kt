package com.example.bottomnavigation

import android.app.Application
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import javax.net.ssl.*
import javax.security.cert.CertificateException
import javax.security.cert.X509Certificate

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
                okhttpClient = OkHttpClient.Builder().sslSocketFactory(getSSLSocketFactory())
                        .hostnameVerifier(object : HostnameVerifier {
                            override fun verify(p0: String?, p1: SSLSession?): Boolean {
                                return true
                            }
                        })
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

        fun getSSLSocketFactory(): SSLSocketFactory? {
            return try { // Create a trust manager that does not validate certificate chains
                val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
                        object : X509TrustManager {
                            @Throws(CertificateException::class)
                            fun checkClientTrusted(chain: Array<X509Certificate?>?, authType: String?) {
                            }

                            @Throws(CertificateException::class)
                            fun checkServerTrusted(chain: Array<X509Certificate?>?, authType: String?) {
                            }

                            val acceptedIssuers: Array<X509Certificate?>?
                                get() = arrayOf()

                            override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
                            }

                            override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
                            }

                            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                                return arrayOf()
                            }
                        }
                )
                // Install the all-trusting trust manager
                val sslContext: SSLContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())
                // Create an ssl socket factory with our all-trusting manager
                sslContext.getSocketFactory()
            } catch (e: KeyManagementException) {
                null
            } catch (e: NoSuchAlgorithmException) {
                null
            }
        }
    }


}