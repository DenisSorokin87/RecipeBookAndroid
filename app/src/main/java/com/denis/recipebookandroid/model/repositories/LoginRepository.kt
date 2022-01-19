package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.LoginDataSource
import com.denis.recipebookandroid.model.app.App
import com.denis.recipebookandroid.model.data.LoggedInUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository() {

    fun login(loginName: String, password: String, loginDataSource: LoginDataSource) {
       App.appInstance.loginService.makeLogIn(loginName, password).
       enqueue(object : Callback<LoggedInUser> {
           override fun onResponse(call: Call<LoggedInUser>, response: Response<LoggedInUser>) {
               response.body()?.let {
                   loginDataSource.onSuccess(it.displayName)
               }
           }
           override fun onFailure(call: Call<LoggedInUser>, t: Throwable) {
              loginDataSource.onError(t)
           }
       })
    }


}