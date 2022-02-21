package com.denis.recipebookandroid.model.dao.data_base

import androidx.room.Database
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.IngredientEntityDao

@Database(entities = [IngredientEntity::class], version = 1 )
abstract class AppIngredientDataBase {
    abstract fun getIngredientEntityDao(): IngredientEntityDao
}