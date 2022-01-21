package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.CallResult
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.LoginResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("/RecipeBook-1.0/rest/login/")
    fun makeLogIn(@Query("loginName") loginName: String, @Query("password") password: String): Call<LoginResult>

    @GET("/RecipeBook-1.0/rest/login/checkIfExist")
    fun checkIfLoginExist(@Query("loginName") loginName: String): Call<Boolean>

    @POST("/RecipeBook-1.0/rest/user/createUser")
    fun createNewUser(@Body user: User): Call<CallResult>
}