package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.IRecipeApiDataSource
import com.denis.recipebookandroid.model.api.api_datasources.RecipeApiDataSource
import com.denis.recipebookandroid.model.dao.db_datasources.RecipeDbDataSource
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.interfaces.IUserMainRepository
import com.denis.recipebookandroid.model.states.CallResult

class UserMainRepository(
    private val recipeApiDataSource: IRecipeApiDataSource,
    private val recipeDbDataSource: RecipeDbDataSource
) : IUserMainRepository {
    override suspend fun getAllRecipes(): CallResult<RecipeEntity> {
        return recipeApiDataSource.getAllRecipes()
    }

    override suspend fun getRecipesFromDB(): List<RecipeEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun addRecipeToUser(recipeId: Int, userId: Int) {
        TODO("Not yet implemented")
    }


    override suspend fun insertDataToDB(data: List<RecipeEntity>?) {
        recipeDbDataSource.insertDataToDB(data)
    }


}
