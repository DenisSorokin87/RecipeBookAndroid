package com.denis.recipebookandroid.model.repositories

import androidx.lifecycle.LiveData
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.interfaces.ILoggedInUserRepository

class LoggedInUserRepository: ILoggedInUserRepository {
    override suspend fun getAllMyRecipes(dataSourceCall: DataSourceCall<List<Recipe>>) {
        TODO("Not yet implemented")
    }

    override suspend fun sortResipesByType(dataSourceCall: DataSourceCall<List<Recipe>>) {
        TODO("Not yet implemented")
    }

    override suspend fun searchRecipe(dataSourceCall: DataSourceCall<LiveData<Recipe>>) {
        TODO("Not yet implemented")
    }

}