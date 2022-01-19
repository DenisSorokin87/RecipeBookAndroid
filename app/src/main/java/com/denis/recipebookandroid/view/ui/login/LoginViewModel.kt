package com.denis.recipebookandroid.view.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.data.LoggedInUser
import com.denis.recipebookandroid.model.repositories.LoginRepository
import com.denis.recipebookandroid.model.states.LoadingState

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _liveData = MutableLiveData<LoggedInUser>()
    val liveData: LiveData<LoggedInUser> = _liveData // another option to make MutableLiveData unchangeable to the user at the Activity/Fragment
    private val _loadingState = MutableLiveData<LoadingState>()

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

   fun makeLogIn(login: String, password: String){
       _liveData.value = loginRepository.login(login, password)
   }

    fun checkIfLoginExist(login: String){
//        _liveData.value = "You can use this Login Name"
    }


}