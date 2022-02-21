package com.denis.recipebookandroid.view.ui.logged_in_user

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.TextureView
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.view.ui.adapers.RecipeRecyclerAdapter

class LoggedInUserFragment : Fragment(R.layout.user_main_fragment) {


    private lateinit var recipesRecycler: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeRecyclerAdapter
    private lateinit var viewModel: LoggedInUserViewModel
    private lateinit var userName: TextView
    private lateinit var toolBar: Toolbar
    private lateinit var sortBySpinner: Spinner
    private lateinit var sortBySpinnerAdapter: SpinnerAdapter
    private lateinit var sortBtn: Button
    private lateinit var searchRecipe: EditText
    private lateinit var searchBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = view.findViewById(R.id.logged_id_user_name)
        toolBar = view.findViewById(R.id.toolbar)
        sortBySpinner = view.findViewById(R.id.sort_by)
        sortBtn = view.findViewById(R.id.sort_button)
        searchRecipe = view.findViewById(R.id.recipe_search)
        searchBtn = view.findViewById(R.id.search_button)

        viewModel = ViewModelProvider(this)[LoggedInUserViewModel::class.java]

    }


    fun getAllMyRecipes(userId: Int){

    }

    fun sortRecipesByType(userId: Int, type: String){

    }

    fun searchRecipe(userId: Int, searchWord: String){

    }

}