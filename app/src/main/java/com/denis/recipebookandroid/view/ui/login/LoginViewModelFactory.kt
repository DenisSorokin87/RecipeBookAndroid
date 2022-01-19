package com.denis.recipebookandroid.view.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.model.app.App
import com.denis.recipebookandroid.model.repositories.LoginRepository

class LoginViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(LoginRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}