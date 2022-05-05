package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RecipeService {

    @GET("/recipe/getAll")
    suspend fun getAllRecipes(): CallResult<List<RecipeEntity>>

    @POST("/recipe/addNew")
    suspend fun createNewRecipe(@Body recipe: Recipe): CallResult<RecipeEntity>

    @POST
    suspend fun addAllRecipes(@Body recipeList: List<Recipe>) : CallResult<List<RecipeEntity>>

    @POST
    suspend fun updateRecipe(@Body recipe: Recipe): CallResult<RecipeEntity>
}
