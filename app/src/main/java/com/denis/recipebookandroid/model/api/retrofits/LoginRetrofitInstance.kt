package com.denis.recipebookandroid.model.api.retrofits

import com.denis.recipebookandroid.model.api.LoginService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginRetrofitInstance {

    private val loginRetrofit: Retrofit
    private const val BASE_URL = "http://10.0.2.2:8080"
    init {
        val gson: Gson = GsonBuilder().setLenient().create()

        loginRetrofit = Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create(gson)).
        build()
        println("retrofit created")
    }

    fun getLoginServiceInstance(): LoginService{
        return loginRetrofit.create(LoginService::class.java)
    }
}