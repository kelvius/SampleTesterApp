package com.example.sampletesterapp.ui.auth

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sampletesterapp.R
import com.example.sampletesterapp.databinding.ActivityLoginBinding
import com.example.sampletesterapp.utils.hide
import com.example.sampletesterapp.utils.show
import com.example.sampletesterapp.utils.toast
import com.testfairy.TestFairy
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(),
    AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
        TestFairy.setServerEndpoint("https://6427267.testfairy.com")
        TestFairy.begin(this, "SDK-udGnr6Uz");


        crashButton.text = "Crash!"
        //Enable this to test CrashLitics reporting toll at
        //https://console.firebase.google.com/project/sampletesterapp/crashlytics/app/
        //android:com.example.sampletesterapp/issues?time=last-seven-days&state=open&type=crash

//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//            addContentView(crashButton, ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT))
//        }


    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }

    override fun onTextDisplay(email: String) {
        toast("Welcome,$email")
        tv_text.text = "Welcome,$email"
    }
}

