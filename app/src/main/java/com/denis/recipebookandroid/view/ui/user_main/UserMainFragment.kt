package com.denis.recipebookandroid.view.ui.user_main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.adapers.RecipeRecyclerAdapter
import com.denis.recipebookandroid.view.ui.create_recipe.RecipeCreateFragment
import com.denis.recipebookandroid.view.ui.login.LoginFragment
import com.denis.recipebookandroid.view.ui.login.LoginViewModel
import com.denis.recipebookandroid.view.ui.login.LoginViewModelFactory

class UserMainFragment : Fragment(R.layout.user_main_fragment) {


//    private val userMainFragment by viewModels<UserMainViewModel>()

    private lateinit var userViewModel: UserMainViewModel
    private lateinit var loginViewModel:LoginViewModel
//    private val loginViewModel: LoginViewModel by activityViewModels()
    private lateinit var recipesRecycler: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeRecyclerAdapter
    private lateinit var signInBtn: Button
    private lateinit var userNameTitle: TextView
    private lateinit var progress: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInBtn = view.findViewById(R.id.sign_in_btn)
        userNameTitle= view.findViewById(R.id.logged_id_user_name)
        progress = view.findViewById(R.id.loading)

        userViewModel = ViewModelProvider(requireActivity(), UserMainViewModelFactory(requireActivity().application))[UserMainViewModel::class.java]
        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory())[LoginViewModel::class.java]

        loginViewModelObserve()
        recipeRecyclerInit(view)
        observeForLiveData()
        signInBtnListener()

        userViewModel.getAllRecipes()

    }


    private fun loginViewModelObserve() {
        loginViewModel.loggedInLiveData.observe(requireActivity()){
           if(it != null) {
               signInBtn.visibility = View.GONE
               userNameTitle.text = it.displayName
               userNameTitle.visibility = View.VISIBLE

           }else {
               signInBtn.visibility = View.VISIBLE
               userNameTitle.visibility = View.GONE
           }

        }
    }

    private fun signInBtnListener() {
        signInBtn.setOnClickListener {
            (requireActivity() as MainActivity).showUpperFragment(RecipeCreateFragment::class.java)
            signInBtn.visibility = View.GONE
        }
    }

    private fun recipeRecyclerInit(view: View) {
        recipesRecycler = view.findViewById(R.id.recipes_recycler)
        recipesRecycler.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        recipeRecyclerAdapter = RecipeRecyclerAdapter(requireActivity())
        recipeRecyclerAdapter.onClick = {
            println(it)
        }
        recipesRecycler.adapter = recipeRecyclerAdapter

    }

    private fun observeForLiveData() {
        userViewModel.userLiveData.observe(requireActivity()){
            when(it){
                is LoadingState.LOADING -> progress.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    progress.visibility = View.GONE
                    setRecipeRecycler(it.data)
                }
                is LoadingState.Error -> {
                    progress.visibility = View.GONE
                    Toast.makeText(
                    requireActivity(),
                    it.error,
                    Toast.LENGTH_LONG
                ).show()
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setRecipeRecycler(recipesList: List<Recipe>){
        recipeRecyclerAdapter.recipeList = recipesList
        recipeRecyclerAdapter.notifyDataSetChanged()
    }

}