package com.rafengimprove.practice.exam

class ReverseXor {

    fun reverseWithXor(string: String): String {

        if (string.length < 2) return string

        val charArray = string.toCharArray()

        var start = 0
        var end = charArray.size - 1

        while (start < end) {
            charArray[start] = charArray[start].code.xor(charArray[end].code).toChar()
            charArray[end] = charArray[start].code.xor(charArray[end].code).toChar()
            charArray[start] = charArray[start].code.xor(charArray[end].code).toChar()
            start++
            end--
        }

        return String(charArray)
    }
}