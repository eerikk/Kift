package com.kift.storage.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Eerik on 14/10/17.
 */
class ApiClient {

    private val BASE_URL = "http://kift.place:1337/api/"

    val service: KiftService

    init {
        val interceptor = getInterceptor()
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = getRetrofit(client)
        service = retrofit.create(KiftService::class.java)
    }

    private fun getInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}