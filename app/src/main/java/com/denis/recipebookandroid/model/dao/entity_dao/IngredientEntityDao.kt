package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity


@Dao
interface IngredientEntityDao {

    @Query("SELECT * FROM IngredientEntity")
    suspend fun getAll(): List<IngredientEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ingredient: IngredientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ingredientList: List<IngredientEntity>)

    @Update
    suspend fun update(ingredient: IngredientEntity)

    @Delete
    suspend fun delete(ingredient: IngredientEntity)
}
