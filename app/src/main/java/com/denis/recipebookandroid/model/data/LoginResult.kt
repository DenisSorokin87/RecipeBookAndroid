package com.denis.recipebookandroid.model.data

data class LoginResult(
    val loggedInUser: LoggedInUser = LoggedInUser(),
    val status: String,
    val error: String = ""
)
