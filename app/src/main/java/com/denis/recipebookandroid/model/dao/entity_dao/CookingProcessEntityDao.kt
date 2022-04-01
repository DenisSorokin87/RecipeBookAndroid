package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity

@Dao
interface CookingProcessEntityDao {

    @Query("SELECT * FROM CookingProcessEntity")
    fun getAll(): List<CookingProcessEntity>

    @Insert
    fun insert(task: CookingProcessEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(list : List<CookingProcessEntity>)

    @Update
    fun update(task: CookingProcessEntity)

    @Delete
    fun delete(task: CookingProcessEntity)

}