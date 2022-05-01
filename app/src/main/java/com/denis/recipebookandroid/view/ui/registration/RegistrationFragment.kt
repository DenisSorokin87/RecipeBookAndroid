package com.denis.recipebookandroid.view.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.FragmentRegistrationBinding
import com.denis.recipebookandroid.model.data.User
import com.denis.recipebookandroid.model.states.LoadingState
import com.denis.recipebookandroid.view.ui.MainActivity
import com.denis.recipebookandroid.view.ui.login.LoginFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {


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

        registerBtnListener()

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