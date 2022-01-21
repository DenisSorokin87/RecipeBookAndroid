package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.LoginRetrofitInstance
import com.denis.recipebookandroid.model.data.CallResult
import com.denis.recipebookandroid.model.data.LoginResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInUpRepository() {
    private val loginService = LoginRetrofitInstance.getLoginServiceInstance()

    fun login(loginName: String, password: String, dataSourceCall: DataSourceCall) {
       val signInCall = loginService.makeLogIn(loginName, password)
       signInCall.enqueue(object : Callback<LoginResult> {
           override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
               response.body()?.let {
                when(it.status){
                    "SUCCESS" -> dataSourceCall.onSuccess(it.loggedInUser.displayName)
                    "FAILED" -> dataSourceCall.onError(it.error)
                }
               }
           }
           override fun onFailure(call: Call<LoginResult>, t: Throwable) {
               t.message?.let { dataSourceCall.onError(it) }
           }
       })
    }

    fun createNewUser(user: User, dataSourceCall: DataSourceCall){
        val signUpCall = loginService.createNewUser(user)
        signUpCall.enqueue(object : Callback<CallResult>{
                override fun onResponse(call: Call<CallResult>, response: Response<CallResult>) {
                    response.body()?.let {
                        when(it.status){
                            "SUCCESS"-> {
                                login(user.loginName, user.password, object : DataSourceCall{
                                    override fun onSuccess(data: Any) {
                                        dataSourceCall.onSuccess(data)
                                    }

                                    override fun onError(error: String) {
                                        dataSourceCall.onError("Sing In Was Failed, Try to  make log in again")
                                    }
                                })

                            }
                            "FAILED" -> dataSourceCall.onError("user creating failed")
                        }
                    }
                }

                override fun onFailure(call: Call<CallResult>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }


}