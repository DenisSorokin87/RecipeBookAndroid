package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity

@Dao
interface CookingProcessEntityDao {

    @Query("SELECT * FROM CookingProcessEntity")
    fun getAll(): List<CookingProcessEntity>

    @Insert
    fun insert(task: CookingProcessEntity)

    @Update
    fun update(task: CookingProcessEntity)

    @Delete
    fun delete(task: CookingProcessEntity)

}