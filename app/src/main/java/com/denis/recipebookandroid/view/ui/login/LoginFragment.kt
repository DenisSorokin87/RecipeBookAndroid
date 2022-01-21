package com.denis.recipebookandroid.view.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.registration.RegistrationFragment

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
        val signUpBtn: Button = view.findViewById(R.id.sign_up_btn)
        val progressBar: ProgressBar = view.findViewById(R.id.loading)

        logInBtn.setOnClickListener(View.OnClickListener {
            loginViewModel.makeLogIn(loginText.text.toString(), passwordText.text.toString())

        })


        signUpBtn.setOnClickListener(View.OnClickListener {
            (requireActivity() as MainActivity).showFragment(RegistrationFragment::class.java)
        })


        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory())[LoginViewModel::class.java]

        loginViewModel.loginLiveData.observe(requireActivity(), {
            when(it){
                LoadingState.LOADING -> progressBar.visibility = View.VISIBLE
                is LoadingState.LOADED ->{
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(), "Login Made !!!!! + ${it.data}", Toast.LENGTH_LONG).show()
                }
                is LoadingState.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(), "Error.... Fuck You " + it.error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}