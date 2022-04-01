package com.denis.recipebookandroid.model.repositories

import android.content.Context
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

interface IUserMainRepository {

    suspend fun getAllRecipes(): CallResult<Recipe>

    suspend fun getRecipesFromDB(): List<Recipe>

    fun addRecipeToUser(recipeId: Int, userId: Int)

    suspend fun insertDataToDB(context: Context, data: List<RecipeEntity>?)
}