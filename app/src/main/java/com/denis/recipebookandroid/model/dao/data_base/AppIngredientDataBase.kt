package com.denis.recipebookandroid.model.dao.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.IngredientEntityDao

@Database(entities = [IngredientEntity::class], version = 1 )
abstract class AppIngredientDataBase : RoomDatabase() {
    abstract fun getIngredientEntityDao(): IngredientEntityDao
}