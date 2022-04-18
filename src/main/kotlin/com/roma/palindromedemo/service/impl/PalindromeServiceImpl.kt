package com.roma.palindromedemo.service.impl

import com.roma.palindromedemo.service.PalindromeService

// the implementation depends on whether we consider an empty string as a palindrome
// if empty string is not palindrome we need check phrase.isEmpty()
class PalindromeServiceImpl : PalindromeService {

    override fun isPalindrome(phrase: String): Boolean {
        return phrase
            .replace("\\W".toRegex(), "")
            .equals(
                StringBuilder(phrase.replace("\\W".toRegex(), ""))
                    .reverse()
                    .toString(), ignoreCase = true
            )
    }

}