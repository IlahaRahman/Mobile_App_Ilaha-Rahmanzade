package com.mobileapps

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobileapps.lesson2.R
import androidx.fragment.app.Fragment

class AccountActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        if (savedInstanceState == null) {
            replaceFragment(LoginFragment())
        }

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val registerNowTextView = findViewById<TextView>(R.id.registerNowTextView)

        registerNowTextView.setOnClickListener {
            replaceFragment(RegisterFragment())
        }


        nextButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()


            if (!credentialsManager.isEmailValid(email)) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            } else if (!credentialsManager.isPasswordValid(password)) {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                replaceFragment(LoginFragment())
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
