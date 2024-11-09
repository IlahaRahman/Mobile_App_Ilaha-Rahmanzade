// CredentialsManagerTest.kt
package com.mobileapps.lesson2


import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val isEmailValid = credentialsManager.isEmailValid("")
        assertFalse(isEmailValid)
    }

    @Test
    fun givenInvalidEmailFormat_thenReturnFalse() {
        val isEmailValid = credentialsManager.isEmailValid("invalidEmail")
        assertFalse(isEmailValid)
    }

    @Test
    fun givenValidEmailFormat_thenReturnTrue() {
        val isEmailValid = credentialsManager.isEmailValid("example@example.com")
        assertTrue(isEmailValid)
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val isPasswordValid = credentialsManager.isPasswordValid("")
        assertFalse(isPasswordValid)
    }

    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val isPasswordValid = credentialsManager.isPasswordValid("password123")
        assertTrue(isPasswordValid)
    }
}
