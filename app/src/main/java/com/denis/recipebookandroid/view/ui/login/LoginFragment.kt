package com.denis.recipebookandroid.view.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.FragmentLoginBinding
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.BlankFragment
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.registration.RegistrationFragment
import com.denis.recipebookandroid.view.ui.user_main.UserMainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val loginViewModel: LoginViewModel by viewModel()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logInBtnListener()
        signUpBtnListener()

        loginLiveDataObserve()
    }

    private fun loginLiveDataObserve() {
        loginViewModel.loginLiveData.observe(requireActivity()) {
            when (it) {
                is LoadingState.LOADING -> binding.loading.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(
                        requireActivity(),
                        "Login Made !!!!! + ${it.data.displayName}",
                        Toast.LENGTH_LONG
                    ).show()
                    (requireActivity() as MainActivity).showBottomFragment(UserMainFragment::class.java)
                    (requireActivity() as MainActivity).showUpperFragment(BlankFragment::class.java)
                }
                is LoadingState.Error -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(
                        requireActivity(),
                        "Error.... " + it.error,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun signUpBtnListener() {
        binding.signUpBtn.setOnClickListener(View.OnClickListener {
            (requireActivity() as MainActivity).showUpperFragment(RegistrationFragment::class.java)
        })
    }

    private fun logInBtnListener() {
        binding.loginBtn.setOnClickListener(View.OnClickListener {
            loginViewModel.makeLogIn(
                binding.userLoginName.text.toString(),
                binding.userPassword.text.toString()
            )

        })
    }
}