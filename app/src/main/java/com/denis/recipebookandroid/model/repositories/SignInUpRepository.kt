package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInUpRepository() {
    private val loginService = RetrofitInstance.getLoginServiceInstance()

    fun login(loginName: String, password: String, dataSourceCall: DataSourceCall<LoggedInUser>) {
       val signInCall = loginService.makeLogIn(loginName, password)
       signInCall.enqueue(object : Callback<CallResult<LoggedInUser>> {
           override fun onResponse(call: Call<CallResult<LoggedInUser>>, response: Response<CallResult<LoggedInUser>>) {
               response.body()?.let {
                when(it.status){
                    "SUCCESS" -> it.dataList?.let { it1 -> dataSourceCall.onSuccess(it1.last()) }
                    "FAILED" -> dataSourceCall.onError(it.msg)
                    else -> {throw Exception()}
                }
               }
           }
           override fun onFailure(call: Call<CallResult<LoggedInUser>>, t: Throwable) {
               t.message?.let { dataSourceCall.onError(it) }
           }
       })
    }

    fun createNewUser(user: User, dataSourceCall: DataSourceCall<String>){
        val signUpCall = loginService.createNewUser(user)
        signUpCall.enqueue(object : Callback<CallResult<Nothing>>{
                override fun onResponse(call: Call<CallResult<Nothing>>, response: Response<CallResult<Nothing>>) {
                    response.body()?.let {
                        when(it.status){
                            "SUCCESS"-> {
                                dataSourceCall.onSuccess(it.status)
                            }
                            "FAILED" -> dataSourceCall.onError("${it.status} - ${it.msg}")
                        }
                    }
                }

                override fun onFailure(call: Call<CallResult<Nothing>>, t: Throwable) {
                    println("Failure + ${t.message}")
                    println(t.cause)
                }

            })

    }


}