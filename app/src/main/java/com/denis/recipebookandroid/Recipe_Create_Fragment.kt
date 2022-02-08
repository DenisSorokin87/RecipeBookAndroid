package com.denis.recipebookandroid

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Recipe_Create_Fragment : Fragment() {

    companion object {
        fun newInstance() = Recipe_Create_Fragment()
    }

    private lateinit var viewModel: RecipeCreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe__create__fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[RecipeCreateViewModel::class.java]
        // TODO: Use the ViewModel
    }

}