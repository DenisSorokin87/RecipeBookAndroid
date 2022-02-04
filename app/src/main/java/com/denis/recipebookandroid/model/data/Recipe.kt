package com.denis.recipebookandroid.model.data

data class Recipe(
    val recipeId: Int,
    val recipeTitle: String,
    val recipePicUrl: String,
    val ingredientList: List<Ingredient>,
    val processList: List<CookingProcess>
)
