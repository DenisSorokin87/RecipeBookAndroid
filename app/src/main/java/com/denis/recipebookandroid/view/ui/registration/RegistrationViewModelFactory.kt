package com.denis.recipebookandroid.view.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.model.repositories.SignInUpRepository


class RegistrationViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            val signUpRepository = SignInUpRepository()
            return RegistrationViewModel(signUpRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}