package com.roma.palindromedemo.service.impl


import com.roma.palindromedemo.service.PalindromeService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class PalindromeServiceImplTest {

    private val palindromeServiceImpl: PalindromeService = PalindromeServiceImpl()

    @Test
    fun isPalindrome() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("hello olleh")
        assertTrue(isPalindrome)
    }

    @Test
    fun isNotPalindrome() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("hello ollehfsd")
        assertFalse(isPalindrome)
    }

    @Test
    fun isPalindromeWithNumbers() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("hello1 olleh")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithPunctuation() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("Borrow , or `*+--       rob!!!! : ???")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithEmptyString() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("")
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeWithBadOrthography() {
        val isPalindrome = palindromeServiceImpl.isPalindrome("Daw, O cowad")
        assertTrue(isPalindrome)
    }

}