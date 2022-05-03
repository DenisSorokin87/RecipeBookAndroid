package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

interface IUserApiDataSource {

    suspend fun getUserRecipes(userId: Long): CallResult<List<Long>>

    suspend fun updateUser(user: User): CallResult<User>

    suspend fun getUser(id: Long): CallResult<User>
}