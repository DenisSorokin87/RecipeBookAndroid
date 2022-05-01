package com.denis.recipebookandroid.model.repositories

import android.content.Context
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.ApiService
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

class RecipeCreateRepository(private val apiService: ApiService) {


    suspend fun createNewRecipe(recipe: Recipe) {
        apiService.createNewRecipe(recipe)
    }
}