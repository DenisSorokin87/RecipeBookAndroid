package com.denis.recipebookandroid.model.dao.converters

import androidx.room.TypeConverter
import com.denis.recipebookandroid.model.dao.entities.CookingProcessEntity
import com.denis.recipebookandroid.model.dao.entities.IngredientEntity
import com.denis.recipebookandroid.model.data.CookingProcess
import com.denis.recipebookandroid.model.data.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun ingredientsArrayLIstToString(ingredientsList: List<IngredientEntity>): String{
      return Gson().toJson(ingredientsList)
    }

    @TypeConverter
    fun stringToIngredientArrayList(ingredientsString: String): List<IngredientEntity>{
//        val listType = object : TypeToken<ArrayList<Ingredient>>(){}.type
       return Gson().fromJson(ingredientsString, Array<IngredientEntity>::class.java).toList()
    }

    @TypeConverter
    fun cookingProcessToString(cookingProcessList: List<CookingProcessEntity>): String{
        return Gson().toJson(cookingProcessList)
    }

    @TypeConverter
    fun stringToCookingProcessList(cookingProcessString: String): List<CookingProcessEntity>{
        return Gson().fromJson(cookingProcessString, Array<CookingProcessEntity>::class.java).toList()
    }
}