package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.ISignInUpApiDataSource
import com.denis.recipebookandroid.model.api.api_datasources.SignInUpApiDataSource
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.repositories.interfaces.ISignInUpRepository

class SignInUpRepository(private val SingInUpDS: ISignInUpApiDataSource) : ISignInUpRepository {
    override suspend fun login(loginName: String, password: String): LoggedInUser {
        TODO("Not yet implemented")
    }

    override suspend fun createNewUser(user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun checkIfLoginExist(loginName: String): Boolean {
        TODO("Not yet implemented")
    }


}