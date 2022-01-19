package com.denis.recipebookandroid.model.states

sealed class LoadingState{

    object LOADING: LoadingState()
    object LOADED : LoadingState()


}
