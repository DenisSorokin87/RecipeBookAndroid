package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity


@Dao
interface IngredientEntityDao {

    @Query("SELECT * FROM IngredientEntity")
    suspend fun getAll(): List<IngredientEntity>

    @Insert
    suspend fun insert(task: IngredientEntity)

    @Update
    suspend fun update(task: IngredientEntity)

    @Delete
    suspend fun delete(task: IngredientEntity)
}
