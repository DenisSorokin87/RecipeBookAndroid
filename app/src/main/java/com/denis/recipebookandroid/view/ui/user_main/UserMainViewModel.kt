package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.model.states.LoadingState

class UserMainViewModel(private val userMainRepository: UserMainRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<LoadingState>()
    val userLiveData: LiveData<LoadingState> = _userLiveData

    fun getAllRecipes(){
        _userLiveData.value = LoadingState.LOADING

        userMainRepository.getAllRecipes(object : DataSourceCall{
            override fun onSuccess(data: Any) {
                _userLiveData.value = LoadingState.LOADED(data)
            }

            override fun onError(error: String) {
               _userLiveData.value = LoadingState.Error(error)
            }

        })
    }
}