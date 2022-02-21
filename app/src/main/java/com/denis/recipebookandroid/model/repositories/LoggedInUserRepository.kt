package com.denis.recipebookandroid.model.repositories

import androidx.lifecycle.LiveData
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe

class LoggedInUserRepository {
    fun getAllMyRecipes(dataSourceCall: DataSourceCall<List<Recipe>>) {
        TODO("Not yet implemented")
    }

    fun sortResipesByType(dataSourceCall: DataSourceCall<List<Recipe>>) {


    }

    fun searchRecipe(dataSourceCall: DataSourceCall<LiveData<Recipe>>) {


    }
}