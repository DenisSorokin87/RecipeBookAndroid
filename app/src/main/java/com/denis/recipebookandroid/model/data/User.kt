package com.denis.recipebookandroid.model.data

data class User(
    val userId: Int,
    val userName: String,
    val password: String,
    val loginName: String,
    val email: String,
    val recipesId: ArrayList<Int>
)
