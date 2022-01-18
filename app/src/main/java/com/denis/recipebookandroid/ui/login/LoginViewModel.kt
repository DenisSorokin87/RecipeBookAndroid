package com.denis.recipebookandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> = mutableLiveData // another option to make MutableLiveData unchangeable to the user at the Activity/Fragment

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
       mutableLiveData.value = "The user is logged in"
   }

    fun checkIfLoginExist(login: String){
        mutableLiveData.value = "You can use this Login Name"
    }


}