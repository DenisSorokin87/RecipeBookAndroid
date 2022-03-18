package com.denis.recipebookandroid.model.repositories

import android.content.Context
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

class RecipeCreateRepository(applicationContext: Context) {
    fun createNewRecipe(recipe: Recipe, callResult: DataSourceCall<List<Recipe>>) {
        TODO("Not yet implemented")
    }
}