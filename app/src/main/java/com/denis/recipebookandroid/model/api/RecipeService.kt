package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RecipeService {

    @GET("/recipe/getAll")
    suspend fun getAllRecipes(): CallResult<List<Recipe>>

    @POST("/recipe/addNew")
    suspend fun createNewRecipe(@Body recipe: Recipe): CallResult<Recipe>

    @POST
    suspend fun addAllRecipes(@Body recipeList: List<Recipe>) : CallResult<List<Recipe>>

    @POST
    suspend fun updateRecipe(@Body recipe: Recipe): CallResult<Recipe>
}
