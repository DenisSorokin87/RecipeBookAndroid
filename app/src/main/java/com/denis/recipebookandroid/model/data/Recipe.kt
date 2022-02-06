package com.denis.recipebookandroid.model.data

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("recipeId")
    val recipeId: Int,
    @SerializedName("dishName")
    val recipeTitle: String,
    @SerializedName("dishPhotoUrl")
    val recipePicUrl: String,
    @SerializedName("productsList")
    val ingredientList: List<Ingredient>,
    @SerializedName("processesList")
    val processList: List<CookingProcess>,
    val type: String
)
