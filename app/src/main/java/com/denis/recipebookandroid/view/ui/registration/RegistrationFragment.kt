package com.denis.recipebookandroid.view.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.FragmentRegistrationBinding
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.login.LoginFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment:  Fragment(R.layout.fragment_registration) {

//    private lateinit var firstName: EditText
//    private lateinit var lastName: EditText
//    private lateinit var loginName: EditText
//    private lateinit var email: EditText
//    private lateinit var userPassword: EditText
//    private lateinit var userPasswordRepeat: EditText
//    private lateinit var progressBar: ProgressBar
//    private lateinit var registerBtn: Button

    private val registerViewModel: RegistrationViewModel by viewModel()

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        firstName = view.findViewById(R.id.user_name)
//        lastName = view.findViewById(R.id.user_last_name)
//        loginName = view.findViewById(R.id.user_login_name)
//        email = view.findViewById(R.id.user_email)
//        userPassword = view.findViewById(R.id.user_password)
//        userPasswordRepeat = view.findViewById(R.id.user_password_repeat)
//        progressBar = view.findViewById(R.id.loading)
//        registerBtn = view.findViewById(R.id.register_btn)

        registerBtnListener()

//        registerViewModel = ViewModelProvider(requireActivity(), RegistrationViewModelFactory())[RegistrationViewModel::class.java]
        viewModelObserve()


    }

    private fun viewModelObserve() {
        registerViewModel.registerLiveData.observe(requireActivity()) {
            when (it) {
                is LoadingState.LOADING -> binding.loading.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(requireActivity(), it.data, Toast.LENGTH_LONG).show()
                    (requireActivity() as MainActivity).showUpperFragment(LoginFragment::class.java)
                }
                is LoadingState.Error -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(requireActivity(), "Error " + it.error, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun registerBtnListener() {
        binding.registerBtn.setOnClickListener {
            if (checkPasswordEquals(
                    binding.userPassword.text.toString(),
                    binding.userPasswordRepeat.text.toString()
                )
            ) {
                registerViewModel.createNewUser(
                    User(
                        binding.userName.text.toString(),
                        binding.userLastName.text.toString(),
                        binding.userPassword.text.toString(),
                        binding.userLoginName.text.toString(),
                        binding.userEmail.text.toString()
                    )
                )
            } else Toast.makeText(
                requireActivity(),
                "Error - Passwords nat match ",
                Toast.LENGTH_LONG
            ).show()
        }
    }


    private fun checkPasswordEquals(password: String?, passwordRepeat: String?): Boolean {
        return password.equals(passwordRepeat)
    }
}