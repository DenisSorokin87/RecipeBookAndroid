package com.denis.recipebookandroid.view.ui.create_recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.RecipeCreateRepository
import com.denis.recipebookandroid.model.states.LoadingState

class RecipeCreateViewModel(private val recipeCreateRepository: RecipeCreateRepository): ViewModel() {

    private val _recipeLiveData = MutableLiveData<LoadingState<List<Recipe>>>()
    val recipeLiveData: LiveData<LoadingState<List<Recipe>>> = _recipeLiveData

    fun createNewRecipe(recipe: Recipe){

        _recipeLiveData.value = LoadingState.LOADING()

        recipeCreateRepository.createNewRecipe(recipe, object : DataSourceCall<List<Recipe>>{
            override fun onSuccess(data: List<Recipe>) {
                TODO("Not yet implemented")
            }

            override fun onError(error: String) {
                TODO("Not yet implemented")
            }

        })

    }
}