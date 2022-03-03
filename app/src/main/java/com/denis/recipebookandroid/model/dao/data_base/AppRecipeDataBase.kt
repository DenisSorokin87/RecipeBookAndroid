package com.denis.recipebookandroid.model.dao.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.denis.recipebookandroid.model.dao.converters.Converters
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.RecipeEntityDao

@Database(entities = [RecipeEntity::class], version = 1 )
@TypeConverters(Converters::class)
abstract class AppRecipeDataBase : RoomDatabase() {
     abstract fun getRecipeEntityDao(): RecipeEntityDao
}