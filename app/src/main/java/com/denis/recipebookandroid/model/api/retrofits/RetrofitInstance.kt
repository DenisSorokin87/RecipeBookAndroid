package com.denis.recipebookandroid.model.api.retrofits

import com.denis.recipebookandroid.model.logger.OkHttpLogs
import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit
    private const val BASE_URL = "http://10.0.2.2:8080"

    init {
        val gson: Gson = GsonBuilder().setLenient().create()

        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(createOkHttpClient(OkHttpLogs()))
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        println("retrofit created")

    }

    private fun createOkHttpClient(logger: HttpLoggingInterceptor.Logger) = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(logger).apply {
            level = HttpLoggingInterceptor.Level.BASIC
        })
        .build()


    fun getLoginServiceInstance(): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    fun getRetrofitInstance(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}