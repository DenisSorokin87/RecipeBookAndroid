package com.denis.recipebookandroid.view.ui.logged_in_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.model.repositories.LoggedInUserRepository

class LoggedInUserViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoggedInUserViewModel::class.java)) {
            val loggedInUserRepository = LoggedInUserRepository()
            return LoggedInUserViewModel(loggedInUserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}