package com.denis.recipebookandroid.view.ui.logged_in_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.repositories.LoggedInUserRepository
import com.denis.recipebookandroid.model.repositories.interfaces.ILoggedInUserRepository
import com.denis.recipebookandroid.model.states.LoadingState

class LoggedInUserViewModel(private val loggedInUserRepository: ILoggedInUserRepository) : ViewModel() {

    private val _loggedInUserLiveData: MutableLiveData<List<LoadingState<List<Recipe>>>> = MutableLiveData()
    val loggedInUserLiveData: LiveData<List<LoadingState<List<Recipe>>>> = _loggedInUserLiveData

    fun getAllMyRecipes(userId: Int){

//        loggedInUserRepository.getAllMyRecipes(object : DataSourceCall<List<Recipe>>{
//            override fun onSuccess(data: List<Recipe>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(error: String) {
//                TODO("Not yet implemented")
//            }
//
//        })
    }

    fun sortRecipesByType(userId: Int, type: String){
//        loggedInUserRepository.sortResipesByType(object: DataSourceCall<List<Recipe>>{
//            override fun onSuccess(data: List<Recipe>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(error: String) {
//                TODO("Not yet implemented")
//            }
//
//        })

    }

    fun searchRecipe(userId: Int, searchWord: String){
//        loggedInUserRepository.searchRecipe(object: DataSourceCall<LiveData<Recipe>>{
//            override fun onSuccess(data: LiveData<Recipe>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(error: String) {
//                TODO("Not yet implemented")
//            }
//
//        })
    }
}