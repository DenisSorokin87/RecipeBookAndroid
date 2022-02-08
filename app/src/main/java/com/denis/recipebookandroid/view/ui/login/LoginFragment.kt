package com.denis.recipebookandroid.view.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.BlankFragment
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.registration.RegistrationFragment
import com.denis.recipebookandroid.view.ui.user_main.UserMainFragment

class LoginFragment : Fragment(R.layout.fragment_login){

//    private val loginViewModel by viewModels<MainViewModel>()
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var isLoggedIn: String
    private lateinit var logInBtn: Button
    private lateinit var loginText: EditText
    private lateinit var passwordText: EditText
    private lateinit var signUpBtn: Button
    private lateinit var progressBar: ProgressBar


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logInBtn = view.findViewById(R.id.loginBtn)
        loginText = view.findViewById(R.id.user_login_name)
        passwordText = view.findViewById(R.id.user_password)
        signUpBtn = view.findViewById(R.id.sign_up_btn)
        progressBar = view.findViewById(R.id.loading)

        logInBtnListener()
        signUpBtnListener()

        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory())[LoginViewModel::class.java]

        loginLiveDataObserve()

    }

    private fun loginLiveDataObserve() {
        loginViewModel.loginLiveData.observe(requireActivity()) {
            when (it) {
                LoadingState.LOADING -> progressBar.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireActivity(),
                        "Login Made !!!!! + ${it.data}",
                        Toast.LENGTH_LONG
                    ).show()
                    (requireActivity() as MainActivity).showBottomFragment(UserMainFragment::class.java)
                    (requireActivity() as MainActivity).showUpperFragment(BlankFragment::class.java)
                }
                is LoadingState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireActivity(),
                        "Error.... Fuck You " + it.error,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun signUpBtnListener() {
        signUpBtn.setOnClickListener(View.OnClickListener {
            (requireActivity() as MainActivity).showUpperFragment(RegistrationFragment::class.java)
        })
    }

    private fun logInBtnListener() {
        logInBtn.setOnClickListener(View.OnClickListener {
            loginViewModel.makeLogIn(loginText.text.toString(), passwordText.text.toString())

        })
    }
}