package com.roma.palindromedemo.service.impl


import com.roma.palindromedemo.service.impl.PalindromeServiceImpl
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class PalindromeServiceImplTest {

    @Test
    fun isPalindrome() {
        val psi = PalindromeServiceImpl()
        val isPalindrome = psi.isPalindrome("а роза упала на лапу Азора")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithPunctuation() {
        val psi = PalindromeServiceImpl()
        val isPalindrome = psi.isPalindrome("а, роза`*+--       упала!!!! на лапу: Азора???")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithEmptyString() {
        val psi = PalindromeServiceImpl()
        val isPalindrome = psi.isPalindrome("")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithBadOrthography() {
        val psi = PalindromeServiceImpl()
        val isPalindrome = psi.isPalindrome("топат тапот")
        assertTrue(isPalindrome)
    }

}