package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.data.Recipe

interface IRecipeCreateRepository {

    suspend fun createNewRecipe(recipe: Recipe) : String
}