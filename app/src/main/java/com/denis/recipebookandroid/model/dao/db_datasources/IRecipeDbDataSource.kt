package com.denis.recipebookandroid.model.dao.db_datasources

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

interface IRecipeDbDataSource {

    suspend fun addRecipeToDb(recipeEntity: RecipeEntity)

    suspend fun insertDataToDB(data: List<RecipeEntity>)

    suspend fun getAllRecipesFromDB() : CallResult<List<Recipe>>
}