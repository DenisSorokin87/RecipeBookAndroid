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

    @GET("/login/SignIn")
   suspend fun makeLogIn(@Query("loginName") loginName: String, @Query("password") password: String): CallResult<LoggedInUser>

    @GET("/login/isLoginExist")
    suspend fun checkIfLoginExist(@Query("loginName") loginName: String): CallResult<Boolean>

    @POST("/login/SignUp")
    suspend fun createNewUser(@Body user: User): CallResult<User>
}