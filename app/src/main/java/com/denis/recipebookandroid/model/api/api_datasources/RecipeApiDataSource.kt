package com.denis.recipebookandroid.model.api.api_datasources

import com.denis.recipebookandroid.model.api.RecipeService
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult

class RecipeApiDataSource(private val recipeService: RecipeService) : IRecipeApiDataSource {

    override suspend fun createNewRecipe(recipe: Recipe): CallResult<RecipeEntity> {
        return try {
            recipeService.createNewRecipe(recipe)
        } catch (e: Exception) {
            CallResult(null, e.message)
        }
    }

    override suspend fun getAllRecipes(): CallResult<List<RecipeEntity>> {
        return try {
            recipeService.getAllRecipes()
        } catch (e: Exception) {
            CallResult(null, e.message)
        }
    }

    override suspend fun updateRecipe(recipe: Recipe): CallResult<RecipeEntity> {
        return try {
            recipeService.updateRecipe(recipe)
        } catch (e: Exception) {
            CallResult(null, e.message)
        }
    }

    override suspend fun addAllRecipes(recipeList: List<Recipe>): CallResult<List<RecipeEntity>> {
        return try {
            recipeService.addAllRecipes(recipeList)
        } catch (e: Exception) {
            CallResult(null, e.message)
        }
    }
}