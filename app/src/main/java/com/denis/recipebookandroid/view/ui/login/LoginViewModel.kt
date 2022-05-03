package com.denis.recipebookandroid.view.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.repositories.SignInUpRepository
import com.denis.recipebookandroid.model.repositories.interfaces.ISignInUpRepository
import com.denis.recipebookandroid.model.states.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val signInUpRepository: ISignInUpRepository) : ViewModel() {

//    private val _liveData = MutableLiveData<LoggedInUser>()
//    val liveData: LiveData<LoggedInUser> = _liveData // another option to make MutableLiveData unchangeable to the user at the Activity/Fragment

    private val _loginLiveData = MutableLiveData<LoadingState<LoggedInUser>>()
    val loginLiveData: LiveData<LoadingState<LoggedInUser>> = _loginLiveData

    private val _loggedInLiveData = MutableLiveData<LoggedInUser>()
    val loggedInLiveData: LiveData<LoggedInUser> = _loggedInLiveData


    init {
        println("ViewModel Created")
    }

    override fun onCleared() {
        println("LoginViewModel is Cleared")
        super.onCleared()
    }

    // one of the options to make MutableLiveData unchangeable to the user at the Activity/Fragment
//    fun getResultData(): LiveData<String>{
//        return liveData
//    }

    fun makeLogIn(login: String, password: String) {
//
//        _loginLiveData.value = LoadingState.LOADING()
//
//
//        viewModelScope.launch(Dispatchers.IO) {
//            _loginLiveData.postValue(LoadingState.LOADED(signInUpRepository.login(login, password)))
////            _loggedInLiveData.value = _loginLiveData.postValue("")
//        }


    }

    fun checkIfLoginExist(login: kotlin.String) {
//        _liveData.value = "You can use this Login Name"
    }


}