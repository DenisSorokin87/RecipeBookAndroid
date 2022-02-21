package com.denis.recipebookandroid.model.dao.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao

@Database(entities = [RecipeEntity::class], version = 1 )
abstract class AppRecipeDataBase : RoomDatabase() {
    abstract fun getRecipeEntityDao(): RecipeEntityDao
}