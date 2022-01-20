package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.LoginDataSource
import com.denis.recipebookandroid.model.api.retrofits.LoginRetrofitInstance
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.LoginResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository() {

    fun login(loginName: String, password: String, loginDataSource: LoginDataSource) {
       val loginService = LoginRetrofitInstance.getLoginServiceInstance()
        val loginCall = loginService.makeLogIn(loginName, password)
       loginCall.enqueue(object : Callback<LoginResult> {
           override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
               response.body()?.let {
                when(it.status){
                    "SUCCESS" -> loginDataSource.onSuccess(it.loggedInUser.displayName)
                    "FAILED" -> loginDataSource.onError(it.error)
                }
               }
           }
           override fun onFailure(call: Call<LoginResult>, t: Throwable) {
               t.message?.let { loginDataSource.onError(it) }
           }
       })
    }


}