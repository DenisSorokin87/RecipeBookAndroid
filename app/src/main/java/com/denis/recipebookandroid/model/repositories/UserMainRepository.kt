package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.IRecipeApiDataSource
import com.denis.recipebookandroid.model.dao.db_datasources.RecipeDbDataSource
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.enum.ResponseStatus
import com.denis.recipebookandroid.model.repositories.interfaces.IUserMainRepository
import com.denis.recipebookandroid.model.states.DataResponse
import com.google.gson.Gson

class UserMainRepository(
    private val recipeApiDataSource: IRecipeApiDataSource,
    private val recipeDbDataSource: RecipeDbDataSource
) : IUserMainRepository {


    override suspend fun getAllRecipes(): DataResponse<List<Recipe>> {
        val result = recipeApiDataSource.getAllRecipes()
        return if (result.data != null){
            recipeDbDataSource.insertDataToDB(result.data)
            DataResponse(convertToRecipe(result.data), ResponseStatus.Success)
        }else DataResponse(null, ResponseStatus.Failed)
    }

    override suspend fun getRecipesFromDB(): DataResponse<List<Recipe>> {
        val result = recipeDbDataSource.getAllRecipesFromDB()
        return if (result.data != null) {
            DataResponse(convertToRecipe(result.data), ResponseStatus.Success)
        } else DataResponse(data = null, ResponseStatus.Failed, result.msg)
    }

    override suspend fun addRecipeToUser(recipeId: Int, userId: Int) {

    }


    override suspend fun insertDataToDB(data: List<RecipeEntity>?) {
//        recipeDbDataSource.insertDataToDB(data)
    }

    private fun convertToRecipe(data: List<RecipeEntity>): List<Recipe>{
        return Gson().fromJson(Gson().toJson(data), Array<Recipe>::class.java).toList()
    }


}
