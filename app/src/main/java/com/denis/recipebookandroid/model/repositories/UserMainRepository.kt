package com.denis.recipebookandroid.model.repositories

import android.content.Context
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.dao.dbInstances.RecipeDBInstance
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import com.google.gson.Gson

class UserMainRepository(private val context: Context) {

    private val apiService = RetrofitInstance.getRetrofitInstance()
    private val recipeDataBase = RecipeDBInstance(context).getRecipeDataBase()
    private val recipeDao: RecipeEntityDao = recipeDataBase.getRecipeEntityDao()

    suspend fun getAllRecipes(): CallResult<Recipe> {

        try {
            val result = apiService.getAllRecipes()
            if (result.dataList.isNullOrEmpty() || result.status == "ERROR") {
                return CallResult(emptyList(), result.status, result.msg)
            }
            insertDataToDB(context, result.dataList)
            return CallResult(getRecipesFromDB(), result.status, result.msg)

        } catch (e: Exception) {
            return CallResult(emptyList(), "ERROR", e.message!!)
        }
    }

    fun getRecipesFromDB(): List<Recipe> {

        return if (recipeDao.getAll()
                .isNotEmpty()
        ) Gson().fromJson(Gson().toJson(recipeDao.getAll()), Array<Recipe>::class.java).toList()
        else return emptyList()
    }


    fun addRecipeToUser(recipeId: Int, userId: Int) {


    }


    private fun insertDataToDB(context: Context, data: List<RecipeEntity>?) {
        recipeDao.cleanSchema()
        data?.forEach { recipeEntity ->
            recipeDao.insert(recipeEntity)
        }
    }


}
