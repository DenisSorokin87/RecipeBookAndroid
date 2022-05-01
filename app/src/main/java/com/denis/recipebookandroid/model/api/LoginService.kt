package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.states.LoginResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("/RecipeBook-1.0/rest/login/")
   suspend fun makeLogIn(@Query("loginName") loginName: String, @Query("password") password: String): LoggedInUser

    @GET("/RecipeBook-1.0/rest/login/checkIfExist")
    suspend fun checkIfLoginExist(@Query("loginName") loginName: String): Call<Boolean>

    @POST("/RecipeBook-1.0/rest/user/createUser")
    suspend fun createNewUser(@Body user: User): Call<CallResult<Nothing>>
}