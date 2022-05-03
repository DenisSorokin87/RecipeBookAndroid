package com.denis.recipebookandroid.model.dao.db_datasources

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao

class RecipeDbDataSource(private val recipeDb: RecipeEntityDao) {


    suspend fun addRecipeToDb(recipeEntity: RecipeEntity?) {
        recipeEntity?.let { recipeDb.insert(it)}
    }

    suspend fun insertDataToDB(data: List<RecipeEntity>?) {
        recipeDb.cleanSchema()
        data?.let { recipeDb.insertAll(it) }
    }


}