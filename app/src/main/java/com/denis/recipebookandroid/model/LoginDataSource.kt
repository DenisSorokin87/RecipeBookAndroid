package com.denis.recipebookandroid.model

import java.lang.Exception

interface LoginDataSource {

    fun onSuccess(data: String)
    fun onError(error: Throwable)
}