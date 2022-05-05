package com.denis.recipebookandroid.view.ui.create_recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.RecipeCreateRepository
import com.denis.recipebookandroid.model.repositories.interfaces.IRecipeCreateRepository
import com.denis.recipebookandroid.model.states.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeCreateViewModel(private val recipeCreateRepository: IRecipeCreateRepository) :
    ViewModel() {

    private val _recipeLiveData = MutableLiveData<LoadingState<Recipe>>()
    val recipeLiveData: LiveData<LoadingState<Recipe>> = _recipeLiveData
    private val _dataLiveData = MutableLiveData<String>()
    val dataLiveData: LiveData<String> = _dataLiveData

    fun createNewRecipe(recipe: Recipe) {

        _recipeLiveData.value = LoadingState.LOADING()

//        viewModelScope.launch(Dispatchers.IO) {
////            _recipeLiveData.postValue(
////                LoadingState.LOADED(
////                    recipeCreateRepository.createNewRecipe(recipe)))
//        }

    }

    fun initSpinner(dataArray: ArrayList<String>) {
        TODO()
    }
}