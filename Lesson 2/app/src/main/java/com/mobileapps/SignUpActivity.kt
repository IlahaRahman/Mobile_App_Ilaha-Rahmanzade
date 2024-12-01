package com.mobileapps

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mobileapps.lesson2.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        nextButton = findViewById(R.id.nextButton)
        loginTextView = findViewById(R.id.loginTextView)

        nextButton.setOnClickListener { validateAndNavigate() }
        loginTextView.setOnClickListener { navigateToAccount() }
    }

    private fun validateAndNavigate() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Email validation
        if (email.isEmpty()) {
            showToast("Please enter your email.")
            return
        } else if (!isValidEmail(email)) {
            showToast("Please enter a valid email.")
            return
        }

        // Password validation
        if (password.isEmpty()) {
            showToast("Please enter your password.")
            return
        } else if (password.length < 6) {
            showToast("Password must be at least 6 characters.")
            return
        }

        // If all validations pass, navigate to the next activity
        navigateToAccount()
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun navigateToAccount() {
        val intent = Intent(this, AccountActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
