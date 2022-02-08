package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.model.states.LoadingState

class UserMainViewModel(private val userMainRepository: UserMainRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<LoadingState<ArrayList<Recipe>>>()
    val userLiveData: LiveData<LoadingState<ArrayList<Recipe>>> = _userLiveData

    fun getAllRecipes(){
        _userLiveData.value = LoadingState.LOADING()

        userMainRepository.getAllRecipes(object : DataSourceCall<ArrayList<Recipe>>{
            override fun onSuccess(data: ArrayList<Recipe>) {
                _userLiveData.value = LoadingState.LOADED(data)
            }

            override fun onError(error: String) {
               _userLiveData.value = LoadingState.Error(error)
            }

        })
    }
}