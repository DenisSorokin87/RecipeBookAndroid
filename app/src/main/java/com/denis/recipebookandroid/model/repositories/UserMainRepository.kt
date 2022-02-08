package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.data.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserMainRepository {

    private val apiService = RetrofitInstance.getRetrofitInstance()

    fun getAllRecipes(dataSource: DataSourceCall<ArrayList<Recipe>>) {
        val getRecipesCall = apiService.getAllRecipes()
        getRecipesCall.enqueue(object : Callback<ArrayList<Recipe>>{
            override fun onResponse(call: Call<ArrayList<Recipe>>, response: Response<ArrayList<Recipe>>) {
                response.body()?.let {
                    dataSource.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<Recipe>>, t: Throwable) {
                dataSource.onError("Connection Problems")
            }

        })
    }

    fun addRecipeToUser(recipeId: Int, userId: Int){

    }

}
