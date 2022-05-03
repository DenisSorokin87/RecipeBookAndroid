package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.api.UserService
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

class UserApiDataSource(private val userService: UserService) : IUserApiDataSource {
    override suspend fun getUserRecipes(userId: Long): CallResult<List<Long>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User): CallResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(id: Long): CallResult<User> {
        TODO("Not yet implemented")
    }
}