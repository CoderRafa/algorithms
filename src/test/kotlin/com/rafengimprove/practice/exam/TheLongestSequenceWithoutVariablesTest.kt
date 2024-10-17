package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TheLongestSequenceWithoutVariablesTest {

    @Test
    fun `Happy pass - the longest sequense is found`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(5, thelongest.theLongestSequence(listOf(1,1,1,0,0,1,1,0,0,0,1,1,1,1,1)))
        assertEquals(5, thelongest.theLongestSequence(listOf(1,1,1,0,0,1,1,0,0,0,1,1,1,1,1,0,0)))
    }

    @Test
    fun `Negative pass - the list is empty`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(0, thelongest.theLongestSequence(listOf()))
    }

    @Test
    fun `Negative pass - all elements in the list are 0`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(0, thelongest.theLongestSequence(listOf(0,0,0,0,0,0,0,0)))
    }

    @Test
    fun `Happy pass - all elements are 1`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(8, thelongest.theLongestSequence(listOf(1,1,1,1,1,1,1,1)))
    }

    @Test
    fun `Happy pass - there are other numbers except from 1 and 0`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(3, thelongest.theLongestSequence(listOf(1,1,4,4,0,0,0,1,1,1,5,0,0,0,0,1)))
    }

    @Test
    fun `Happy pass - the 1s are only at the beginning`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(8, thelongest.theLongestSequence(listOf(1,1,1,1,1,1,1,1,0,0,0,0,0,0,0)))
    }

    @Test
    fun `Happy pass - the 1s are in the middle`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(8, thelongest.theLongestSequence(listOf(0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0)))
    }

    @Test
    fun `Happy pass - the 1s are at the back`() {
        val thelongest = TheLongestSequenceWithoutVariables()

        assertEquals(8, thelongest.theLongestSequence(listOf(0,0,0,0,0,0,1,1,1,1,1,1,1,1)))
    }
}