package com.denis.recipebookandroid.model.dao.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity
import com.denis.recipebookandroid.model.dao.entity_dao.CookingProcessEntityDao


@Database(entities = [CookingProcessEntity::class], version = 1 )
abstract class CookingProcessDataBase : RoomDatabase() {
    abstract fun getCookingProcessEntityDao(): CookingProcessEntityDao
}