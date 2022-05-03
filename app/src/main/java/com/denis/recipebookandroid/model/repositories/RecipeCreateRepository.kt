package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.IRecipeApiDataSource
import com.denis.recipebookandroid.model.api.api_datasources.RecipeApiDataSource
import com.denis.recipebookandroid.model.dao.db_datasources.RecipeDbDataSource
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.enum.ResponseStatus
import com.denis.recipebookandroid.model.repositories.interfaces.IRecipeCreateRepository
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.states.DataResponse

class RecipeCreateRepository(
    private val recipeApiDataSource: IRecipeApiDataSource,
    private val recipeDBDataSource: RecipeDbDataSource
) : IRecipeCreateRepository{

    override suspend fun createNewRecipe(recipe: Recipe) : DataResponse<RecipeEntity> {
       val result = recipeApiDataSource.createNewRecipe(recipe)
        return if (result.data != null){
            recipeDBDataSource.addRecipeToDb(result.data)
            DataResponse(result.data, ResponseStatus.Success, result.msg)
        }else{
            DataResponse(null, ResponseStatus.Failed, result.msg)
        }
    }



}