package com.denis.recipebookandroid.model.repositories

import com.denis.recipebookandroid.model.api.ApiService
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.CallResult
import com.google.gson.Gson

class UserMainRepository(
    private val apiService: ApiService,
    private val recipeDao: RecipeEntityDao
) {


    suspend fun getAllRecipes(): CallResult<Recipe> {

        return try {
            val result = apiService.getAllRecipes()
            if (result.dataList.isNullOrEmpty()) return CallResult(
                emptyList(),
                status = "FAILED",
                result.msg
            )

            insertDataToDB(result.dataList)
            return CallResult(getRecipesFromDB(), result.status, result.msg)
        } catch (e: Exception) {
            CallResult(emptyList(), "FAILED", e.message!!)
        }
    }

    suspend fun getRecipesFromDB(): List<Recipe> {

        return if (recipeDao.getAll()
                .isNotEmpty()
        ) Gson().fromJson(Gson().toJson(recipeDao.getAll()), Array<Recipe>::class.java).toList()
        else return emptyList()
    }


    suspend fun addRecipeToUser(recipeId: Int, userId: Int) {


    }


    private suspend fun insertDataToDB(data: List<RecipeEntity>?) {
        recipeDao.cleanSchema()
        data?.forEach { recipeEntity ->
            recipeDao.insert(recipeEntity)
        }
    }


}
