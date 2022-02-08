package com.denis.recipebookandroid.model.states

import com.denis.recipebookandroid.model.data.LoggedInUser

data class LoginResult(
    val loggedInUser: LoggedInUser = LoggedInUser(),
    val status: String,
    val error: String = ""
)
