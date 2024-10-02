package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RecursiveReverseKtTest {

    @Test
    fun `Happy pass - a string is reversed`() {
        val reversedString = recursiveReverse("hello")
        println(reversedString)
    }
}