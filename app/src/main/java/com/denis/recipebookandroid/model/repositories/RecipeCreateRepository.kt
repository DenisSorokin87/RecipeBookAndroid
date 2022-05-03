package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.api_datasources.IRecipeApiDataSource
import com.denis.recipebookandroid.model.api.api_datasources.RecipeApiDataSource
import com.denis.recipebookandroid.model.dao.db_datasources.RecipeDbDataSource
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.interfaces.IRecipeCreateRepository
import com.denis.recipebookandroid.model.states.CallResult

class RecipeCreateRepository(
    private val recipeApiDataSource: IRecipeApiDataSource,
    private val recipeDBDataSource: RecipeDbDataSource
) : IRecipeCreateRepository{

    override suspend fun createNewRecipe(recipe: Recipe) : String{
       val result = recipeApiDataSource.createNewRecipe(recipe)
        return if (result.data != null){
            recipeDBDataSource.addRecipeToDb(result.data)
            "Recipe Created"
        }else{
            result.msg!!
        }
    }



}