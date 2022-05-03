package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.states.DataResponse

interface IUserMainRepository {

    suspend fun getAllRecipes(): DataResponse<List<RecipeEntity>>

    suspend fun getRecipesFromDB(): DataResponse<List<RecipeEntity>>

    suspend fun addRecipeToUser(recipeId: Int, userId: Int)

    suspend fun insertDataToDB(data: List<RecipeEntity>?)
}