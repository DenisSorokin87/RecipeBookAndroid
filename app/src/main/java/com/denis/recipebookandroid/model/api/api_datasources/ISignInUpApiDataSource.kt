package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

interface ISignInUpApiDataSource {

    suspend fun login(loginName: String, password: String): CallResult<LoggedInUser>

    suspend fun createNewUser(user: User) : CallResult<User>

    suspend fun checkIfLoginExist(loginName: String): CallResult<Boolean>
}