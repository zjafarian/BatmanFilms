package com.example.batmanfilms.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

object RetrofitClientInstance {

    val retrofitService: MainNetworkService by lazy {
        retrofitBuilder.create(MainNetworkService::class.java)
    }


    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(70, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()

            val original = newRequest.build()
            chain.proceed(original)
        }


    private val retrofitBuilder: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NetworkParams.BASE_URL_REQUEST)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}