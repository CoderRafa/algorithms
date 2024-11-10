package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

fun isPalindromeExam(string: String): Boolean {

    if (string.length < 2) return false

    var first = 0
    var second = string.length - 1

    while (first < second) {
        if (string[first] != string[second]) {
            return false
        }
        first++
        second--
    }

    return true
}

class PalindromeExam {

    @Test
    fun `Happy pass - is palindrome`() {
        assertTrue(isPalindromeExam("racecar"))
    }

    @Test
    fun `Negative pass - one letter word can't be a palindrome`() {
        assertFalse(isPalindromeExam("a"))
    }

    @Test
    fun `Negative pass - a word is not a palindrome`() {
        assertFalse(isPalindromeExam("hello"))
    }

    @Test
    fun `Negative pass - an empty string can't be a palindrome`() {
        assertFalse(isPalindromeExam(""))
    }
}