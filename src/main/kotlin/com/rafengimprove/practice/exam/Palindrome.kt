package com.rafengimprove.practice.exam

class Palindrome {
    fun palindrome(string: String): Boolean {
        if (string.length < 2) return false

        var start = 0
        var end = string.length - 1

        while (start < end) {
            if (string[start] != string[end]) return false
            start++
            end--
        }
        return true
    }
}