package com.denis.recipebookandroid.view.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.user_main.UserMainFragment

class LoginFragment : Fragment(R.layout.fragment_login){

//    private val loginViewModel by viewModels<MainViewModel>()
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var isLoggedIn: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("fragment Created")
        val logInBtn: Button = view.findViewById(R.id.loginBtn)
        val loginText: EditText = view.findViewById(R.id.user_login_name)
        val passwordText: EditText = view.findViewById(R.id.user_password)

        logInBtn.setOnClickListener(View.OnClickListener {
            loginViewModel.makeLogIn(loginText.text.toString(), passwordText.text.toString())
            UserMainFragment.newInstance()
        })

        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory())[LoginViewModel::class.java]

        loginViewModel.liveData.observe(requireActivity(), {
            when(it){
                LoadingState.LOADING -> Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_LONG).show()
                is LoadingState.LOADED -> Toast.makeText(requireActivity(), "Login Made !!!!! + ${it.data}", Toast.LENGTH_LONG).show()
                is LoadingState.Error -> Toast.makeText(requireActivity(), "Error.... Fuck You " + it.error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}