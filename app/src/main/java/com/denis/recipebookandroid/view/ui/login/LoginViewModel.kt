package com.denis.recipebookandroid.view.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.LoginDataSource
import com.denis.recipebookandroid.model.repositories.LoginRepository
import com.denis.recipebookandroid.model.states.LoadingState

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

//    private val _liveData = MutableLiveData<LoggedInUser>()
//    val liveData: LiveData<LoggedInUser> = _liveData // another option to make MutableLiveData unchangeable to the user at the Activity/Fragment

    var liveData: MutableLiveData<LoadingState> = MutableLiveData<LoadingState>()


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

       liveData.value = LoadingState.LOADING

       loginRepository.login(login, password, object : LoginDataSource{
           override fun onSuccess(data: String) {
               liveData.value = LoadingState.LOADED(data)
           }

           override fun onError(error: String) {
              liveData.value = LoadingState.Error(error)
           }

       })
   }

    fun checkIfLoginExist(login: kotlin.String){
//        _liveData.value = "You can use this Login Name"
    }


}