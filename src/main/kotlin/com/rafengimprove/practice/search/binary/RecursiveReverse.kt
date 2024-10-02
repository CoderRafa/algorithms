package com.rafengimprove.practice.search.binary

fun recursiveReverse(string: String, index: Int = 0): String {

    if (string.length < 2) return string

    var start = index
    val end = string.length - 1 - start

    val stringToCharacterArray = string.toCharArray()

    if (start < end) {
        stringToCharacterArray[start] = stringToCharacterArray[start].code.xor(stringToCharacterArray[end].code).toChar()
        stringToCharacterArray[end] = stringToCharacterArray[start].code.xor(stringToCharacterArray[end].code).toChar()
        stringToCharacterArray[start] = stringToCharacterArray[start].code.xor(stringToCharacterArray[end].code).toChar()
        return recursiveReverse(String(stringToCharacterArray), ++start)
    }

    return String(stringToCharacterArray)
}