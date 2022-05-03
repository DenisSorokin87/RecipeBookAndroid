package com.denis.recipebookandroid.model.states

import com.denis.recipebookandroid.model.enum.ResponseStatus

data class DataResponse<T>(
    val data: T?,
    val status: ResponseStatus,
    val error: String? = ""
)
