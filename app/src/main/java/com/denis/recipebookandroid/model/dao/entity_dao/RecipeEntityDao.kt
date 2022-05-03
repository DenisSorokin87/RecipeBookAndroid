package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity


@Dao
interface RecipeEntityDao  {

    @Query("SELECT * FROM RecipeEntity")
    suspend fun getAll(): List<RecipeEntity>

    @Query("SELECT * FROM RecipeEntity WHERE recipeId = :id")
    suspend fun getById(id: Long): RecipeEntity?

//    @Query("SELECT * FROM RecipeEntity WHERE userId = :useId")
//    fun getAllUserTasks(useId: Long): List<RecipeEntity>

    @Query("DELETE FROM RecipeEntity")
    suspend fun cleanSchema()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recipeList: List<RecipeEntity>)

    @Update
    suspend fun update(recipe: RecipeEntity)

    @Delete
    suspend fun delete(recipe: RecipeEntity)


}