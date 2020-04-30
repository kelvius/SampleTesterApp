package com.example.sampletesterapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.sampletesterapp.data.repositories.UserRepository
import kotlinx.android.synthetic.main.activity_login.*

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var textDisplay: String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        //onStarted should show login loading animation
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        authListener?.onTextDisplay(email!!)
        // !! = means make sure it is not null
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)

    }
}