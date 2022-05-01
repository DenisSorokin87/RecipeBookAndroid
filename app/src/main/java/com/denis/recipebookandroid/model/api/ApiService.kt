package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @GET("/RecipeBook-1.0/rest/recipe")
    suspend fun getAllRecipes(): CallResult<RecipeEntity>

    @POST("recipe/create")
    suspend fun createNewRecipe(@Body recipe: Recipe): Recipe
}
