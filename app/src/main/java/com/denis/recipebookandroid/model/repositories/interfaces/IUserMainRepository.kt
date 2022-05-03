package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

interface IUserMainRepository {

    suspend fun getAllRecipes(): CallResult<RecipeEntity>

    suspend fun getRecipesFromDB(): List<RecipeEntity>

    suspend fun addRecipeToUser(recipeId: Int, userId: Int)

    suspend fun insertDataToDB(data: List<RecipeEntity>?)
}