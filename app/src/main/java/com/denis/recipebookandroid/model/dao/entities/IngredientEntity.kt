package com.denis.recipebookandroid.model.dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IngredientEntity(

    @PrimaryKey
    val ingredientId: Long,
    val ingredient: String,
    val ingredientAmount: Int,
    val ingredientAmountUnit: String
)
