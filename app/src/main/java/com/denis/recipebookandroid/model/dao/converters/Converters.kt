package com.denis.recipebookandroid.model.dao.converters

import androidx.room.TypeConverter
import com.denis.recipebookandroid.model.data.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun ingredientsArrayLIstToString(ingredientsList: List<Ingredient>): String{
      return Gson().toJson(ingredientsList)
    }

    @TypeConverter
    fun stringToIngredientArrayList(ingredientsString: String): List<Ingredient>{
//        val listType = object : TypeToken<ArrayList<Ingredient>>(){}.type
       return Gson().fromJson(ingredientsString, Array<Ingredient>::class.java).toList()
    }
}