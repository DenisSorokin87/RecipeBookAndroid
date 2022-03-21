package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.model.states.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserMainViewModel(private val userMainRepository: UserMainRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<LoadingState<List<Recipe>>>()
    val userLiveData: LiveData<LoadingState<List<Recipe>>> = _userLiveData

    fun getAllRecipes() {
        _userLiveData.value = LoadingState.LOADING()
        viewModelScope.launch(Dispatchers.IO) {

            val callResult = userMainRepository.getAllRecipes()
            if (callResult.dataList.isNullOrEmpty()) {
                _userLiveData.postValue(LoadingState.Error(callResult.msg))
                getRecipesFromLocalDB()
            }
            _userLiveData.postValue(LoadingState.LOADED(callResult.dataList!!))
        }
    }

    private fun getRecipesFromLocalDB() {
        viewModelScope.launch(Dispatchers.IO) {
            if (userMainRepository.getRecipesFromDB().isNullOrEmpty())
                _userLiveData.postValue(LoadingState.Error("There is no data stored in Data Base")
            )
            else _userLiveData.postValue(LoadingState.LOADED(userMainRepository.getRecipesFromDB()))
        }
    }
}