package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity


@Dao
interface IngredientEntityDao {

    @Query("SELECT * FROM IngredientEntity")
    fun getAll(): List<IngredientEntity>

    @Insert
    fun insert(task: IngredientEntity)

    @Update
    fun update(task: IngredientEntity)

    @Delete
    fun delete(task: IngredientEntity)
}
