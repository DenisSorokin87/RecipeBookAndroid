package com.denis.recipebookandroid.model.dao.dbInstances

import android.content.Context
import androidx.room.Room
import com.denis.recipebookandroid.model.dao.data_base.AppRecipeDataBase

class RecipeDBInstance(private val context: Context) {

    private val recipeDataBase: AppRecipeDataBase? = null

    fun getRecipeDataBase(): AppRecipeDataBase {

        return recipeDataBase ?: Room.databaseBuilder(
            context,
            AppRecipeDataBase::class.java,
            "Recipes_Data_Base"
        ).build()
    }
}