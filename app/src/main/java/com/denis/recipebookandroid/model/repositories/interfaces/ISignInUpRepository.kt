package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.DataResponse

interface ISignInUpRepository {

    suspend fun login(loginName: String, password: String): DataResponse<LoggedInUser>

    suspend fun createNewUser(user: User) : DataResponse<User>

    suspend fun checkIfLoginExist(loginName: String): DataResponse<Boolean>
}