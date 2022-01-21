package com.denis.recipebookandroid.model.data

import kotlin.String

data class User(

    val userName: String,
    val userLastName: String,
    val password: String,
    val loginName: String,
    val email: String,
    val userId: Int = -1,
    val recipesId: ArrayList<Int> = ArrayList()
)
