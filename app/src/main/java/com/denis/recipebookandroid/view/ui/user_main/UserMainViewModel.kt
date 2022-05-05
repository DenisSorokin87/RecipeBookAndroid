package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.enum.ResponseStatus
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.model.repositories.interfaces.IUserMainRepository
import com.denis.recipebookandroid.model.states.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserMainViewModel(private val userMainRepository: IUserMainRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<LoadingState<List<Recipe>>>()
    val userLiveData: LiveData<LoadingState<List<Recipe>>> = _userLiveData

    fun getAllRecipes() {
        _userLiveData.value = LoadingState.LOADING()
        viewModelScope.launch(Dispatchers.IO) {
            val response = userMainRepository.getAllRecipes()
            when (response.status) {
                ResponseStatus.Success -> _userLiveData.postValue(LoadingState.LOADED(response.data!!))
                ResponseStatus.Failed -> {
                    _userLiveData.postValue(LoadingState.Error(response.error!!))
                    getRecipesFromLocalDB()
                }
            }
        }
    }

    private fun getRecipesFromLocalDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userMainRepository.getRecipesFromDB()
            when (result.status) {
                ResponseStatus.Failed -> {
                    _userLiveData.postValue(
                        LoadingState.Error("There is no data stored in Data Base"))
                }
                ResponseStatus.Success -> _userLiveData.postValue(
                    LoadingState.LOADED(
                        result.data!!
                    )
                )
            }
        }
    }
}