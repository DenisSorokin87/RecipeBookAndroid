package com.denis.recipebookandroid.view.ui.create_recipe

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.model.repositories.RecipeCreateRepository

class RecipeCreateViewModelFactory(private val application: Application) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeCreateViewModel::class.java)) {
            val recipeCreateRepository = RecipeCreateRepository(application.applicationContext)
            return RecipeCreateViewModel(recipeCreateRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}