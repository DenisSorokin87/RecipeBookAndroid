package com.denis.recipebookandroid.model.repositories

import android.content.Context
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.dao.db_instances.RecipeDBInstance
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import com.google.gson.Gson

class UserMainRepository(private val context: Context): IUserMainRepository {

    private val apiService = RetrofitInstance.getRetrofitInstance()
    private val recipeDataBase = RecipeDBInstance(context).getRecipeDataBase()
    private val recipeDao: RecipeEntityDao = recipeDataBase.getRecipeEntityDao()

    override suspend fun getAllRecipes(): CallResult<Recipe> {

        return try {
            val result = apiService.getAllRecipes()
            if (result.dataList.isNullOrEmpty()) return CallResult(
                emptyList(),
                status = "FAILED",
                result.msg
            )

            insertDataToDB(context, result.dataList)
            return CallResult(getRecipesFromDB(), result.status, result.msg)
        } catch (e: Exception) {
            CallResult(emptyList(), "FAILED", e.message!!)
        }
    }

    override suspend fun getRecipesFromDB(): List<Recipe> {

        return if (recipeDao.getAll()
                .isNotEmpty()
        ) Gson().fromJson(Gson().toJson(recipeDao.getAll()), Array<Recipe>::class.java).toList()
        else return emptyList()
    }


    override fun addRecipeToUser(recipeId: Int, userId: Int) {


    }


    override suspend fun insertDataToDB(context: Context, data: List<RecipeEntity>?) {
        recipeDao.cleanSchema()
        if (data != null) {
            recipeDao.insertAll(data)
        }
    }


}
