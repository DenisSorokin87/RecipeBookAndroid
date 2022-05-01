package com.denis.recipebookandroid.view.ui.user_main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.UserMainFragmentBinding
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.adapers.RecipeRecyclerAdapter
import com.denis.recipebookandroid.view.ui.create_recipe.RecipeCreateFragment
import com.denis.recipebookandroid.view.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserMainFragment : Fragment(R.layout.user_main_fragment) {

    private val userViewModel: UserMainViewModel by viewModel()
    private val loginViewModel: LoginViewModel by viewModel()

    private var _binding: UserMainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipeRecyclerAdapter: RecipeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserMainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModelObserve()
        recipeRecyclerInit()
        observeForLiveData()
        signInBtnListener()

        userViewModel.getAllRecipes()

    }


    private fun loginViewModelObserve() {
        loginViewModel.loggedInLiveData.observe(requireActivity()) {
            if (it != null) {
                binding.signInBtn.visibility = View.GONE
                binding.loggedIdUserName.text = it.displayName
                binding.loggedIdUserName.visibility = View.VISIBLE

            } else {
                binding.signInBtn.visibility = View.VISIBLE
                binding.loggedIdUserName.visibility = View.GONE
            }

        }
    }

    private fun signInBtnListener() {
        binding.signInBtn.setOnClickListener {
            (requireActivity() as MainActivity).showUpperFragment(RecipeCreateFragment::class.java)
            binding.signInBtn.visibility = View.GONE
        }
    }

    private fun recipeRecyclerInit() {
        binding.recipesRecycler.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        recipeRecyclerAdapter = RecipeRecyclerAdapter(requireActivity())
        recipeRecyclerAdapter.onClick = {
            println(it)
        }
        binding.recipesRecycler.adapter = recipeRecyclerAdapter

    }

    private fun observeForLiveData() {
        userViewModel.userLiveData.observe(requireActivity()) {
            when (it) {
                is LoadingState.LOADING -> binding.loading.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    binding.loading.visibility = View.GONE
                    setRecipeRecycler(it.data)
                }
                is LoadingState.Error -> {
                    binding.loading.visibility = View.GONE
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
    fun setRecipeRecycler(recipesList: List<Recipe>) {
        recipeRecyclerAdapter.recipeList = recipesList
        recipeRecyclerAdapter.notifyDataSetChanged()
    }

}