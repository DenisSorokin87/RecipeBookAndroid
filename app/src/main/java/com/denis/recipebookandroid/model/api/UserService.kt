package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @GET
    suspend fun getUserRecipes(@Query("userId") userId: Long): CallResult<List<Long>>

    @POST
    suspend fun updateUser(@Body user: User): CallResult<User>
}