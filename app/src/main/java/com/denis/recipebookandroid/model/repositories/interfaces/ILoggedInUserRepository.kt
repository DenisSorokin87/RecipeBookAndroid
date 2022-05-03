package com.denis.recipebookandroid.model.repositories.interfaces

import androidx.lifecycle.LiveData
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe

interface ILoggedInUserRepository {

    suspend fun getAllMyRecipes(dataSourceCall: DataSourceCall<List<Recipe>>)

    suspend fun sortResipesByType(dataSourceCall: DataSourceCall<List<Recipe>>)

    suspend fun searchRecipe(dataSourceCall: DataSourceCall<LiveData<Recipe>>)
}