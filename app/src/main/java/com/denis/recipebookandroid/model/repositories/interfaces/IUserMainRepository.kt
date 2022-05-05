package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.DataResponse

interface IUserMainRepository {

    suspend fun getAllRecipes(): DataResponse<List<Recipe>>

    suspend fun getRecipesFromDB(): DataResponse<List<Recipe>>

    suspend fun addRecipeToUser(recipeId: Int, userId: Int)

    suspend fun insertDataToDB(data: List<RecipeEntity>?)
}