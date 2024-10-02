package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecursivePalindromeCheckKtTest {

    @Test
    fun `Happy pass - the word is a palindrome`() {
        val palindrome = recursivePalindrome("racecar")
        assertTrue(palindrome)
    }

    @Test
    fun `Happy pass - the word is a palindrome and contains the same characters`() {
        val palindrome = recursivePalindrome("oo")
        assertTrue(palindrome)
    }

    @Test
    fun `Negative pass - a word is not a palindrome`() {
        val notPalindrome = recursivePalindrome("hello")
        assertFalse(notPalindrome)
    }

    @Test
    fun `Negative pass - string has less than two characters`() {
        val notPalindrome = recursivePalindrome("r")
        assertFalse(notPalindrome)
    }

    @Test
    fun `Negative pass - string is empty`() {
        val notPalindrome = recursivePalindrome("")
        assertFalse(notPalindrome)
    }
}