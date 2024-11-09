// CredentialsManager.kt

package com.mobileapps.lesson2

class CredentialsManager {

    // Check if email is valid
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(Regex(emailRegex))
    }

    // Check if password is valid
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}
