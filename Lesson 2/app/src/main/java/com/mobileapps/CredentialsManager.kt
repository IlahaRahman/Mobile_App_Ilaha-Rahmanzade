package com.mobileapps

class CredentialsManager {


    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(Regex(emailRegex))
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}
