package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.data.User

interface ISignInUpRepository {

    suspend fun login(loginName: String, password: String)

    suspend fun createNewUser(user: User)

}
