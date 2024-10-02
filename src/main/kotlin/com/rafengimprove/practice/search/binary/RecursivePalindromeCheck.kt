package com.rafengimprove.practice.search.binary


fun recursivePalindrome(string: String, index: Int = 0): Boolean {

    if (string.length < 2) return false

    var passedIndex = index

    if (string[passedIndex] != string[string.length - 1 - passedIndex])
        return false
    else if (passedIndex < string.length - 1 - passedIndex)
        recursivePalindrome(string, ++passedIndex)

    return true
}

