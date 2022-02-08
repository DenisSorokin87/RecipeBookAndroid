package com.denis.recipebookandroid.model

import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.states.CallResult
import java.lang.Exception

interface DataSourceCall<in T: Any> {

    fun onSuccess(data: T)
    fun onError(error: String)
}