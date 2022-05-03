package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.api.UserService
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

class UserApiDataSource(private val userService: UserService) : IUserApiDataSource {


    override suspend fun getUserRecipes(userId: Long): CallResult<List<Long>> {
        return try {
            userService.getUserRecipes(userId)
        }catch (e: Exception){
            throw Exception(e)
        }
    }

    override suspend fun updateUser(user: User): CallResult<User> {
        return try {
            userService.updateUser(user)
        }catch (e: Exception){
            throw Exception(e)
        }
    }

    override suspend fun getUser(id: Long): CallResult<User> {
       return CallResult(null, "User")
    }
}