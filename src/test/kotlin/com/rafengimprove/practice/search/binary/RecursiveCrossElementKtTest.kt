package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RecursiveCrossElementKtTest {

    @Test
    fun `Happy pass - there is a common element`() {
        val result = recursiveCrossElement(listOf(5,3,1,2,7), listOf(9,10,2))
        assertTrue(result)
    }

    @Test
    fun `Negative pass - there aren't common elements`() {
        val result = recursiveCrossElement(listOf(5,3,1,2,7), listOf(9,10,4,6))
        assertFalse(result)
    }
}