package com.denis.recipebookandroid.view.ui.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.BlankFragment
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.login.LoginFragment

class RegistrationFragment:  Fragment(R.layout.fragment_registration) {

    private lateinit var registerViewModel: RegistrationViewModel
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var loginName: EditText
    private lateinit var email: EditText
    private lateinit var userPassword: EditText
    private lateinit var userPasswordRepeat: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var registerBtn: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstName = view.findViewById(R.id.user_name)
        lastName = view.findViewById(R.id.user_last_name)
        loginName = view.findViewById(R.id.user_login_name)
        email = view.findViewById(R.id.user_email)
        userPassword = view.findViewById(R.id.user_password)
        userPasswordRepeat = view.findViewById(R.id.user_password_repeat)
        progressBar = view.findViewById(R.id.loading)
        registerBtn = view.findViewById(R.id.register_btn)

        registerBtnListener()

        registerViewModel = ViewModelProvider(requireActivity(), RegistrationViewModelFactory())[RegistrationViewModel::class.java]
        viewModelObserve()


    }

    private fun viewModelObserve() {
        registerViewModel.registerLiveData.observe(requireActivity()) {
            when (it) {
                is LoadingState.LOADING -> progressBar.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireActivity(), "Registration success ", Toast.LENGTH_LONG).show()
                    (requireActivity() as MainActivity).showUpperFragment(BlankFragment::class.java)
                }
                is LoadingState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireActivity(), "Error " + it.error, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun registerBtnListener() {
        registerBtn.setOnClickListener(View.OnClickListener {
            if(checkPasswordEquals(userPassword.text.toString(), userPasswordRepeat.text.toString())){
                registerViewModel.createNewUser(User(firstName.text.toString(), lastName.text.toString(), userPassword.text.toString()
                    ,loginName.text.toString(), email.text.toString()))
            }else Toast.makeText(requireActivity(), "Error - Passwords nat match ", Toast.LENGTH_LONG).show()
        })
    }


    private fun checkPasswordEquals(password: String?, passwordRepeat: String?): Boolean {
        return password.equals(passwordRepeat)
    }
}