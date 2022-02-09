package com.denis.recipebookandroid.model.api.retrofits

import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit
    private const val BASE_URL = "http://192.168.1.13:8080"
    init {
        val gson: Gson = GsonBuilder().setLenient().create()

        retrofit = Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create(gson)).
        build()
        println("retrofit created")
    }

    fun getLoginServiceInstance(): LoginService{
        return retrofit.create(LoginService::class.java)
    }

    fun getRetrofitInstance(): ApiService {
        return  retrofit.create(ApiService::class.java)
    }
}