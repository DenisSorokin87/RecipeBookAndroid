package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.CallResult

class SignInUpApiDataSource(private val loginService: LoginService) : ISignInUpApiDataSource {

    override suspend fun login(loginName: String, password: String): CallResult<LoggedInUser> {
        return try {
            loginService.makeLogIn(loginName, password)

        } catch (e: Exception) {
            CallResult(null, e.message, e)
        }
    }

    override suspend fun createNewUser(user: User) : CallResult<User> {

        return try {
            loginService.createNewUser(user)
        }catch (e: Exception){
            CallResult(null, e.message, e)
        }
    }

    override suspend fun checkIfLoginExist(loginName: String): CallResult<Boolean> {
        return try {
            loginService.checkIfLoginExist(loginName)
        }catch (e: Exception){
            CallResult(null, e.message, e)
        }
    }
}