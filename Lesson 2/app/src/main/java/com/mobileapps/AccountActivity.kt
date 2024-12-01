package com.mobileapps

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobileapps.lesson2.R

class AccountActivity : AppCompatActivity() {

    // CredentialsManager instance for validation
    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)  // Email input field
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)  // Password input field
        val nextButton = findViewById<Button>(R.id.nextButton)  // Next button (not login button)
        val registerNowTextView = findViewById<TextView>(R.id.registerNowTextView)  // Register link

        //Set an onClickListener to navigate to SignUpActivity
        registerNowTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Next button click for validation
        nextButton.setOnClickListener {
            val email = emailEditText.text.toString()  // Get email input
            val password = passwordEditText.text.toString()  // Get password input

            // Validate email and password
            if (!credentialsManager.isEmailValid(email)) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            } else if (!credentialsManager.isPasswordValid(password)) {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
