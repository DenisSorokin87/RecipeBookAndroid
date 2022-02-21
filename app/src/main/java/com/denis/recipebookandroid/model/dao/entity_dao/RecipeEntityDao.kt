package com.denis.recipebookandroid.model.dao.entity_dao

import androidx.room.*
import com.denis.recipebookandroid.model.dao.entities.RecipeEntity


@Dao
interface RecipeEntityDao  {

    @Query("SELECT * FROM RecipeEntity")
    fun getAll(): List<RecipeEntity>

    @Query("SELECT * FROM RecipeEntity WHERE recipeId = :id")
    fun getById(id: Long): RecipeEntity?

//    @Query("SELECT * FROM RecipeEntity WHERE userId = :useId")
//    fun getAllUserTasks(useId: Long): List<RecipeEntity>

    @Query("DELETE FROM RecipeEntity")
    fun cleanSchema()

    @Insert
    fun insert(task: RecipeEntity)

    @Update
    fun update(task: RecipeEntity)

    @Delete
    fun delete(task: RecipeEntity)


}