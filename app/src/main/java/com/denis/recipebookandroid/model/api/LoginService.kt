package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.LoggedInUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {

    @GET("/RecipeBook-1.0/rest/login")
    fun makeLogIn(@Query("loginName") loginName: kotlin.String, @Query("password") password: kotlin.String): Call<LoggedInUser>

    @GET("/RecipeBook-1.0/rest/login/checkIfExist")
    fun checkIfLoginExist(@Query("loginName") loginName: kotlin.String): Call<Boolean>
}