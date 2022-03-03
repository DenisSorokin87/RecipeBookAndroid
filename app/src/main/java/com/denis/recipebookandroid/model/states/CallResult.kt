package com.denis.recipebookandroid.model.states

import com.google.gson.annotations.SerializedName

data class CallResult<T>(
    val dataList: List<T>?,
    val status: String,
    val msg: String
)
