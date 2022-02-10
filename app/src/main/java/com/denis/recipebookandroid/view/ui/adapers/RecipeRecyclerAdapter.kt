package com.denis.recipebookandroid.view.ui.adapers

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.data.Recipe

class RecipeRecyclerAdapter(var context: Context, var recipeList: List<Recipe> = emptyList()): RecyclerView.Adapter<RecipeRecyclerAdapter.UserViewHolder>()  {

    var onClick: ((ingredients: ArrayList<String>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val recipeList = LayoutInflater.from(context).inflate(R.layout.recipe_item, parent, false)
        return UserViewHolder(recipeList)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.recipeTitle.text = recipeList[position].recipeTitle
        holder.dishType.text = recipeList[position].type
        holder.recipePic.setImageResource(R.drawable.recipe_default_image)
        holder.dishDescription.text = recipeList[position].dishDescription

        //Setting Ingredients To ListView
        val strIngredientsList = ArrayAdapter(
            context, R.layout.list_view_text_style, recipeList[position].ingredientList
        )
        holder.ingredientsList.adapter = strIngredientsList

        holder.ingredientsList.setOnItemClickListener { parent, view, pos, id ->
            onClick?.invoke(getIngredients(recipeList[position]))
        }


        //Setting Processes ToListView
        val strProcessList = ArrayAdapter(
            context, R.layout.list_view_text_style, recipeList[position].processList
        )
        holder.processList.adapter = strProcessList

    }

    private fun getProcesses(recipe: Recipe): ArrayList<String> {
       val processesList =ArrayList<String>()
        recipe.processList.let {
            it.forEach { process ->
                processesList.add(process.toString())
            }
        }
        return processesList
    }

    private fun getIngredients(recipe: Recipe): ArrayList<String> {
        val ingredientsList = ArrayList<String>()
        recipe.ingredientList.let {
            it.forEach { ingredient ->
                ingredientsList.add(ingredient.toString())
            }
        }
        return ingredientsList
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var recipeTitle: TextView = itemView.findViewById(R.id.recipe_title)
        var dishType: TextView = itemView.findViewById(R.id.dish_type)
        var dishDescription: TextView = itemView.findViewById(R.id.dish_description)
        var recipePic: ImageView = itemView.findViewById(R.id.recipe_picture)
        var ingredientsList: ListView = itemView.findViewById(R.id.ingredients_list)
        var processList: ListView = itemView.findViewById(R.id.cooking_process_list)

    }

}