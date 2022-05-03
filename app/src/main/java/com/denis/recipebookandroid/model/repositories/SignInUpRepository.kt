package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.ISignInUpApiDataSource
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.enum.ResponseStatus
import com.denis.recipebookandroid.model.repositories.interfaces.ISignInUpRepository
import com.denis.recipebookandroid.model.states.DataResponse

class SignInUpRepository(private val signInUpDS: ISignInUpApiDataSource) : ISignInUpRepository {

    override suspend fun login(loginName: String, password: String): DataResponse<LoggedInUser> {
        val result = signInUpDS.login(loginName, password)
        return if (result.data != null) {
            DataResponse(result.data, ResponseStatus.Success)
        } else DataResponse(data = null, ResponseStatus.Failed, result.msg)
    }

    override suspend fun createNewUser(user: User): DataResponse<User> {
        val result = signInUpDS.createNewUser(user = user)
        return if (result.data != null) {
            DataResponse(result.data, ResponseStatus.Success)
        } else {
            DataResponse(data = null, ResponseStatus.Failed, result.msg)
        }
    }

    override suspend fun checkIfLoginExist(loginName: String): DataResponse<Boolean> {
        val result = signInUpDS.checkIfLoginExist(loginName)
        return if (result.data != null && result.data == true) {
            DataResponse(result.data, ResponseStatus.Success)
        } else DataResponse(data = null, ResponseStatus.Failed, result.msg)
    }

}