package com.denis.recipebookandroid.view.ui.adapers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.model.data.Recipe

class RecipeRecyclerAdapter(var context: Context, var recipeList: List<Recipe> = emptyList()): RecyclerView.Adapter<RecipeRecyclerAdapter.UserViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}