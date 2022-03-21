package com.denis.recipebookandroid.model.states

data class CallResult<T>(
    val dataList: List<T>?,
    val status: String,
    val msg: String
)
