package com.denis.recipebookandroid.view.ui.user_main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.adapers.RecipeRecyclerAdapter
import com.denis.recipebookandroid.view.ui.login.LoginFragment

class UserMainFragment : Fragment(R.layout.user_main_fragment) {


//    private val userMainFragment by viewModels<UserMainViewModel>()
    private lateinit var userViewModel: UserMainViewModel
    private lateinit var recipesRecycler: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeRecyclerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signInBtn: Button = view.findViewById(R.id.sign_in_btn)
        val userNameTitle: TextView = view.findViewById(R.id.logged_id_user_name)

        userViewModel = ViewModelProvider(requireActivity(), UserMainViewModelFactory())[UserMainViewModel::class.java]

        recipeRecyclerInit(view)

        signInBtn.setOnClickListener(View.OnClickListener {
            (requireActivity() as MainActivity).showUpperFragment(LoginFragment::class.java)
            signInBtn.visibility = View.GONE
        })

        observeForLiveData()

        userViewModel.getAllRecipes()

    }

    private fun recipeRecyclerInit(view: View) {
        recipesRecycler = view.findViewById(R.id.recipes_recycler)
        recipesRecycler.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        recipeRecyclerAdapter = RecipeRecyclerAdapter(requireActivity())
        recipesRecycler.adapter = recipeRecyclerAdapter

    }

    private fun observeForLiveData() {
        userViewModel.userLiveData.observe(requireActivity()){
            when(it){
                is LoadingState.LOADED -> setRecipeRecycler(it.data as ArrayList<Recipe>)
                is LoadingState.Error -> Toast.makeText(
                    requireActivity(),
                    it.error,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setRecipeRecycler(recipesList: ArrayList<Recipe>){
        recipeRecyclerAdapter.recipeList = recipesList
        recipeRecyclerAdapter.notifyDataSetChanged()
    }

}