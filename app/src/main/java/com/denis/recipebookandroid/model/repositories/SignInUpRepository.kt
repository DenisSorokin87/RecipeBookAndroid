package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.LoginService
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInUpRepository(private val loginService: LoginService) {

    suspend fun login(loginName: String, password: String) : LoggedInUser {
     return loginService.makeLogIn(loginName, password)

    }

    suspend fun createNewUser(user: User, dataSourceCall: DataSourceCall<String>){
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