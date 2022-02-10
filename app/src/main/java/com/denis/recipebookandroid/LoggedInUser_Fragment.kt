package com.denis.recipebookandroid

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LoggedInUser_Fragment : Fragment() {

    companion object {
        fun newInstance() = LoggedInUser_Fragment()
    }

    private lateinit var viewModel: LoggedInUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.logged_in_user__fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoggedInUserViewModel::class.java]
        // TODO: Use the ViewModel
    }

}