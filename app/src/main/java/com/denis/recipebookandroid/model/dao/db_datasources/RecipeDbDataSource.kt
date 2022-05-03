package com.denis.recipebookandroid.model.dao.db_datasources

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao
import com.denis.recipebookandroid.model.states.CallResult

class RecipeDbDataSource(private val recipeDb: RecipeEntityDao) : IRecipeDbDataSource {


    override suspend fun addRecipeToDb(recipeEntity: RecipeEntity?) {
        recipeEntity?.let { recipeDb.insert(it)}
    }

    override suspend fun insertDataToDB(data: List<RecipeEntity>) {
        recipeDb.cleanSchema()
        data.let { recipeDb.insertAll(it) }
    }

    override suspend fun getAllRecipesFromDB() : CallResult<List<RecipeEntity>>{
        return try {
            CallResult(recipeDb.getAll(), msg = "")
        } catch (e: Exception){
            CallResult(data = null, e.message)
        }
    }

}