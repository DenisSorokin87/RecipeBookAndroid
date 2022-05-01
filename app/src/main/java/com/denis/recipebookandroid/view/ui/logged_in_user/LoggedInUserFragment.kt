package com.denis.recipebookandroid.view.ui.logged_in_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.LoggedInUserFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoggedInUserFragment : Fragment(R.layout.user_main_fragment) {


    private val loggedInUserViewModel: LoggedInUserViewModel by viewModel()

    private var _binding: LoggedInUserFragmentBinding? = null
    private val binding get() = _binding!!

    //
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoggedInUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelObserve()

    }

    private fun viewModelObserve() {
        loggedInUserViewModel.loggedInUserLiveData.observe(requireActivity()){

        }
    }


    fun getAllMyRecipes(userId: Int) {

    }

    fun sortRecipesByType(userId: Int, type: String) {

    }

    fun searchRecipe(userId: Int, searchWord: String) {

    }

}
