package com.denis.recipebookandroid.model.repositories.interfaces

import com.denis.recipebookandroid.model.dao.entities.RecipeEntity
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.DataResponse

interface IRecipeCreateRepository {

    suspend fun createNewRecipe(recipe: Recipe) : DataResponse<RecipeEntity>
}