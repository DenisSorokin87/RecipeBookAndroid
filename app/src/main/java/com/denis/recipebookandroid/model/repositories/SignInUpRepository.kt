package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.states.LoginResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInUpRepository() {
    private val loginService = RetrofitInstance.getLoginServiceInstance()

    fun login(loginName: String, password: String, dataSourceCall: DataSourceCall<LoggedInUser>) {
       val signInCall = loginService.makeLogIn(loginName, password)
       signInCall.enqueue(object : Callback<LoginResult> {
           override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
               response.body()?.let {
                when(it.status){
                    "SUCCESS" -> dataSourceCall.onSuccess(it.loggedInUser)
                    "FAILED" -> dataSourceCall.onError(it.error)
                }
               }
           }
           override fun onFailure(call: Call<LoginResult>, t: Throwable) {
               t.message?.let { dataSourceCall.onError(it) }
           }
       })
    }

    fun createNewUser(user: User, dataSourceCall: DataSourceCall<CallResult>){
        val signUpCall = loginService.createNewUser(user)
        signUpCall.enqueue(object : Callback<CallResult>{
                override fun onResponse(call: Call<CallResult>, response: Response<CallResult>) {
                    response.body()?.let {
                        when(it.status){
                            "SUCCESS"-> {
                                dataSourceCall.onSuccess(response.body()!!)
                            }
                            "FAILED" -> dataSourceCall.onError("user creating failed")
                        }
                    }
                }

                override fun onFailure(call: Call<CallResult>, t: Throwable) {
                    println("Failure + ${t.message}")
                    println(t.cause)
                }

            })

    }


}