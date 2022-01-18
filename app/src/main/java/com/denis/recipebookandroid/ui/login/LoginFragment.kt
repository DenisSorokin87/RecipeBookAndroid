package com.denis.recipebookandroid.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R

class LoginFragment : Fragment(R.layout.fragment_login){

//    private val loginViewModel by viewModels<MainViewModel>()
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var isLoggedIn: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("fragment Created")
        val logInBtn: Button = view.findViewById(R.id.loginBtn)
        logInBtn.setOnClickListener(View.OnClickListener {
            loginViewModel.makeLogIn("Denis", "Sorokin")
        })
        val loginText: EditText = view.findViewById(R.id.user_login_name)
        val passwordText: EditText = view.findViewById(R.id.user_password)
        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory())[LoginViewModel::class.java]

        loginViewModel.liveData.observe(requireActivity(), {
            isLoggedIn = it
            println(isLoggedIn)
        })
    }
}