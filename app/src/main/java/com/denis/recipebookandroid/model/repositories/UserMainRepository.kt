package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserMainRepository {

    private val apiService = RetrofitInstance.getRetrofitInstance()

    fun getAllRecipes(dataSource: DataSourceCall<List<Recipe>>) {
        val getRecipesCall = apiService.getAllRecipes()
        getRecipesCall.enqueue(object : Callback<CallResult<Recipe>>{
            override fun onResponse(call: Call<CallResult<Recipe>>, response: Response<CallResult<Recipe>>) {
                response.body()?.let {
                    it.data?.let { recipesList -> dataSource.onSuccess(recipesList) }
                }
            }

            override fun onFailure(call: Call<CallResult<Recipe>>, t: Throwable) {
                dataSource.onError("Connection Problems")
            }

        })
    }

    fun addRecipeToUser(recipeId: Int, userId: Int){

    }

}
