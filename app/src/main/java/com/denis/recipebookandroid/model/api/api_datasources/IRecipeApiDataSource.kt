package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

interface IRecipeApiDataSource {

    suspend fun createNewRecipe(recipe: Recipe): CallResult<RecipeEntity>

    suspend fun getAllRecipes(): CallResult<RecipeEntity>

    suspend fun updateRecipe(recipe: Recipe) : CallResult<Recipe>

    suspend fun addAllRecipes(recipeList: List<Recipe>) : CallResult<List<RecipeEntity>>
}