package com.denis.recipebookandroid.model.dao.data_base

import androidx.room.Database
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.dao.entity_dao.CookingProcessEntityDao

@Database(entities = [CookingProcessEntity::class], version = 1 )
abstract class CookingProcessEntity {
    abstract fun getCookingProcessEntityDao(): CookingProcessEntityDao
}