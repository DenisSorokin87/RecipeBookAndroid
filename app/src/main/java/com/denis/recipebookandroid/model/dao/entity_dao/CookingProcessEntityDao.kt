package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity

@Dao
interface CookingProcessEntityDao {

    @Query("SELECT * FROM CookingProcessEntity")
    suspend fun getAll(): List<CookingProcessEntity>

    @Insert
    suspend fun insert(task: CookingProcessEntity)

    @Update
    suspend fun update(task: CookingProcessEntity)

    @Delete
    suspend fun delete(task: CookingProcessEntity)

}