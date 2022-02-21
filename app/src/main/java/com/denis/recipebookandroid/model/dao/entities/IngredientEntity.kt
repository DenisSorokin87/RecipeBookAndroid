package com.denis.recipebookandroid.model.dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IngredientEntity(

    @PrimaryKey
    val ingredientId: Int,
    val ingredient: String,
    val ingredientAmount: Int,
    val ingredientAmountUnit: String
)
