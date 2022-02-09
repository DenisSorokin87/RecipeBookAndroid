package com.denis.recipebookandroid.model.states

import com.google.gson.annotations.SerializedName

data class CallResult<T>(
    @SerializedName("dataList")
    val data: List<T>?,
    val status: String,
    val msg: String
)
