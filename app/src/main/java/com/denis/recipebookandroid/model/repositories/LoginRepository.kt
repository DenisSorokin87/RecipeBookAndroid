package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.app.App
import com.denis.recipebookandroid.model.data.LoggedInUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginRepository() {



    fun login(loginName: String, password: String): LoggedInUser{
//       App.instance.loginService.makeLogIn(loginName, password).
//       enqueue(object : Callback<LoggedInUser> {
//           override fun onResponse(call: Call<LoggedInUser>, response: Response<LoggedInUser>) {
//               if (response.body() != null) {
//                    val loggedInUser = response.body()
//               }
//           }
//
//           override fun onFailure(call: Call<LoggedInUser>, t: Throwable) {
//               TODO("Not yet implemented")
//           }
//
//       })
        return LoggedInUser(1, "$loginName + $password" )
    }


}