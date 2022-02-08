package com.denis.recipebookandroid.view.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denis.recipebookandroid.model.DataSourceCall
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.repositories.SignInUpRepository
import com.denis.recipebookandroid.model.states.CallResult
import com.denis.recipebookandroid.model.states.LoadingState

class RegistrationViewModel(private val signInUpRepository: SignInUpRepository) : ViewModel() {

    private val _registerLiveData = MutableLiveData<LoadingState<CallResult>>()
    val registerLiveData: LiveData<LoadingState<CallResult>> = _registerLiveData

    fun createNewUser(user: User){
        _registerLiveData.value = LoadingState.LOADING()

        signInUpRepository.createNewUser(user, object: DataSourceCall<CallResult>{
            override fun onSuccess(data: CallResult) {
                _registerLiveData.value = LoadingState.LOADED(data)
            }

            override fun onError(error: String) {
                _registerLiveData.value = LoadingState.Error(error)
            }
        })
    }

}