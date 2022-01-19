package com.denis.recipebookandroid.model.app

import android.app.Application
import androidx.room.Room
import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.repositories.LoginRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    companion object{
        val appInstance: App = App()
    }

    private lateinit var retrofit: Retrofit
    val loginService: LoginService = retrofit.create(LoginService::class.java)
    private lateinit var repository: LoginRepository
    private val BASE_URL = "http://10.0.2.2:8080"

    override fun onCreate() {
        super.onCreate()

        val gson: Gson = GsonBuilder().setLenient().create()

        retrofit = Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build()

    }

    fun getUserRepository(): LoginRepository {
        return repository
    }



}