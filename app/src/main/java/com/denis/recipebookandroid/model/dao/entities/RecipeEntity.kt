package com.denis.recipebookandroid.model.dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denis.recipebookandroid.model.data.CookingProcess
import com.denis.recipebookandroid.model.data.Ingredient
import com.google.gson.annotations.SerializedName

@Entity
data class RecipeEntity(
    @PrimaryKey
    @SerializedName("recipeId")
    val recipeId: Int,
    @SerializedName("dishName")
    val recipeTitle: String,
    @SerializedName("dishPhotoUrl")
    val recipePicUrl: String,
    @SerializedName("description")
    val dishDescription: String,
    @SerializedName("productsList")
    val ingredientList: List<IngredientEntity>,
    @SerializedName("cookingProcessList")
    val processList: List<CookingProcessEntity>,
    val type: String
)
