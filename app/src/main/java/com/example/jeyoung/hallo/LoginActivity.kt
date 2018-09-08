package com.example.jeyoung.hallo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login)

        fun navigateToSignUpActivity() {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent);
        }

        loginWithFbBtn.setOnClickListener {
            navigateToSignUpActivity();
        };

        loginWithGoogleBtn.setOnClickListener {
            navigateToSignUpActivity()
        }

        alreadyHaveAnAccountBtn.setOnClickListener {
            navigateToSignUpActivity()
        }

        loginWithMailBtn.setOnClickListener {
            navigateToSignUpActivity()
        }
    }
}
