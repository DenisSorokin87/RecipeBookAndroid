package com.denis.recipebookandroid.model.states

sealed class LoadingState{

    object LOADING: LoadingState()
    class LOADED(val data: Any) : LoadingState()
    class Error(val error: String) : LoadingState()

}
