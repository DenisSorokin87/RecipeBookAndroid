package com.denis.recipebookandroid.model.data

enum class IngredientAmountUnit{
    GRAM,
    MILLILITER,
    CUPS,
    SPOONS,
    KG,
    PIECE;

    fun getStrArray(): ArrayList<String> {
        val strArray: ArrayList<String> = ArrayList()
        values().forEach{
            strArray.add(it.toString())
        }
        return strArray
    }

}
