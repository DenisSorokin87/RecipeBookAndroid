package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity

@Dao
interface CookingProcessEntityDao {

    @Query("SELECT * FROM CookingProcessEntity")
    suspend fun getAll(): List<CookingProcessEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cookingProcess: CookingProcessEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cookingProcessList: List<CookingProcessEntity>)

    @Update
    suspend fun update(cookingProcess: CookingProcessEntity)

    @Delete
    suspend fun delete(cookingProcess: CookingProcessEntity)

}