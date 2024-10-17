package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseXorTest {

    @Test
    fun `Happy pass - the string is reversed`() {
        val reverse = ReverseXor()

        assertEquals("olleh", reverse.reverseWithXor("hello"))
    }

    @Test
    fun `Negative pass - the list is empty`() {
        val reverse = ReverseXor()

        assertEquals("", reverse.reverseWithXor(""))
    }

    @Test
    fun `Negative pass - a string has only one character`() {
        val reverse = ReverseXor()

        assertEquals("a", reverse.reverseWithXor("a"))
    }
}