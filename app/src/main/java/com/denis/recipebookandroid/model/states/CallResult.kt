package com.denis.recipebookandroid.model.states

data class CallResult<T>(
    val data: T?,
    val msg: String?,
    val e: Exception?
)
