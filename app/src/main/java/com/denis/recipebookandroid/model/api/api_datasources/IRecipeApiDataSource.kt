package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

interface IRecipeApiDataSource {

    suspend fun createNewRecipe(recipe: Recipe): CallResult<Recipe>

    suspend fun getAllRecipes(): CallResult<List<Recipe>>

    suspend fun updateRecipe(recipe: Recipe) : CallResult<Recipe>

    suspend fun addAllRecipes(recipeList: List<Recipe>) : CallResult<List<Recipe>>
}