package com.denis.recipebookandroid.model.data

data class CookingProcess(
//    val processId: Int,
    val processNumber: Int,
    val description: String
){
    override fun toString(): String {
        return "$processNumber  $description"
    }
}
