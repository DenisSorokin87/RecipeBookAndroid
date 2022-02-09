package com.denis.recipebookandroid.model.api

import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {

    @GET("/RecipeBook-1.0/rest/recipe")
    fun getAllRecipes(): Call<CallResult<Recipe>>

}
