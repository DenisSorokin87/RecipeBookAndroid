package com.denis.recipebookandroid.model.states

sealed class LoadingState<out T: Any>{

    class LOADING<out T: Any>: LoadingState<T>()
    class LOADED<out T: Any>(val data: T) : LoadingState<T>()
    class Error<out T: Any>(val error: String) : LoadingState<T>()

}
