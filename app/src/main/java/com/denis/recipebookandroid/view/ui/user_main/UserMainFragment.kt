package com.denis.recipebookandroid.view.ui.user_main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.denis.recipebookandroid.R

class UserMainFragment : Fragment(R.layout.user_main_fragment) {

    companion object {
        fun newInstance() = UserMainFragment()
    }

    private lateinit var viewModel: UserMainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserMainViewModel::class.java]
    }

}