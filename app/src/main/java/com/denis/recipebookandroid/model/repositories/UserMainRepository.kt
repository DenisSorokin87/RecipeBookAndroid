package com.denis.recipebookandroid.model.repositories

import android.content.Context
import androidx.room.TypeConverter
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.dao.DBInstances.RecipeDBInstance
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserMainRepository(private val context: Context) {

    private val apiService = RetrofitInstance.getRetrofitInstance()
    private val recipeDataBase = RecipeDBInstance(context).getRecipeDataBase()
    private val recipeDao: RecipeEntityDao = recipeDataBase.getRecipeEntityDao()

    fun getAllRecipes(dataSource: DataSourceCall<List<Recipe>>) {

        val getRecipesCall = apiService.getAllRecipes()

        getRecipesCall.enqueue(object : Callback<CallResult<RecipeEntity>>{
            override fun onResponse(call: Call<CallResult<RecipeEntity>>, response: Response<CallResult<RecipeEntity>>) {

                response.body()?.let {

                    insertDataToDB(context, it.dataList)

                    it.dataList?.let { dataSource.onSuccess(getDataFromDB()) }
                }
            }
            override fun onFailure(call: Call<CallResult<RecipeEntity>>, t: Throwable) {
                dataSource.onError("Connection Problems")
            }

        })
    }

    fun getRecipesFromDB(): List<Recipe> {
        return getDataFromDB()
    }




    fun addRecipeToUser(recipeId: Int, userId: Int){


    }

    private fun getDataFromDB(): List<Recipe> {

        return if (recipeDao.getAll().isNotEmpty()) Gson().fromJson(Gson().toJson(recipeDao.getAll()), Array<Recipe>::class.java).toList()
        else return emptyList()
    }


    private fun insertDataToDB(context: Context, data: List<RecipeEntity>?) {

        recipeDao.cleanSchema()
        data?.forEach { recipeEntity ->
            recipeDao.insert(recipeEntity)
        }
    }




}
