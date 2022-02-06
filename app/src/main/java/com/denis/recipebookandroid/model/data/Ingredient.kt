package com.denis.recipebookandroid.model.data


data class Ingredient(

    val ingredientId: Int,
    val ingredient: String,
    val ingredientAmount: Int,
    val ingredientAmountUnit: String
){
    override fun toString(): String {
        return "$ingredient - $ingredientAmount $ingredientAmountUnit"
    }
}
