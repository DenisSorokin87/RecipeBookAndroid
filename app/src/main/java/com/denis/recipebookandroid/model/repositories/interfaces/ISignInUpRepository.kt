package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

interface ISignInUpRepository {

    suspend fun login(loginName: String, password: String): LoggedInUser

    suspend fun createNewUser(user: User) : User

    suspend fun checkIfLoginExist(loginName: String): Boolean
}