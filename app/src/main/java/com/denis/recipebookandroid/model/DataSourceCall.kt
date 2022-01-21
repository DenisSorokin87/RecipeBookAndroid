package com.denis.recipebookandroid.model

import java.lang.Exception

interface DataSourceCall {

    fun onSuccess(data: Any)
    fun onError(error: String)
}