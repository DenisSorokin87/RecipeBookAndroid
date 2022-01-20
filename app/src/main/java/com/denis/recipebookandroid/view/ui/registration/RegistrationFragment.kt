package com.denis.recipebookandroid.view.ui.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.denis.recipebookandroid.R

class RegistrationFragment:  Fragment(R.layout.fragment_registration) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var firstName: EditText = view.findViewById(R.id.user_name)
        var lastName: EditText = view.findViewById(R.id.user_last_name)
        var loginName: EditText = view.findViewById(R.id.user_login_name)
        var email: EditText = view.findViewById(R.id.user_email)
        var userPassword: EditText = view.findViewById(R.id.user_password)
        var userPasswordRepeat: EditText = view.findViewById(R.id.user_password_repeat)

        var registerBtn: Button = view.findViewById(R.id.register_btn)

    }
}