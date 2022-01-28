package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.model.repositories.UserMainRepository


class UserMainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserMainViewModel::class.java)) {
            val userMainRepository = UserMainRepository()
            return UserMainViewModel(userMainRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}