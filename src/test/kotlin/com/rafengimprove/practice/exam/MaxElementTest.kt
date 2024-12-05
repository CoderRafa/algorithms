package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxElementTest {

    @Test
    fun `Happy pass - find max`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(-2,-5,-14,-3,0,25,2,14,7,3))
        assertEquals(25, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(-2,-5,-14,-3,0,25,2,14,7,3))
        assertEquals(25, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(-2,-5,-14,-3,0,25,2,14,7,3))
        assertEquals(25, result3)
    }

    @Test
    fun `Happy pass - find max in a list with only one not 0 element at the beginning`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(2,0,0,0,0,0,0,0,0,0))
        assertEquals(2, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(2,0,0,0,0,0,0,0,0,0))
        assertEquals(2, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(2,0,0,0,0,0,0,0,0,0))
        assertEquals(2, result3)
    }

    @Test
    fun `Happy pass - find max in a list with only one not 0 element in the middle`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(0,0,0,0,0,2,0,0,0,0))
        assertEquals(2, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(0,0,0,0,0,2,0,0,0,0))
        assertEquals(2, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(0,0,0,0,0,2,0,0,0,0))
        assertEquals(2, result3)
    }

    @Test
    fun `Happy pass - find max in a list with only one not 0 element at the end`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(0,0,0,0,0,0,0,0,0,2))
        assertEquals(2, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(0,0,0,0,0,0,0,0,0,2))
        assertEquals(2, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(0,0,0,0,0,0,0,0,0,2))
        assertEquals(2, result3)
    }

    @Test
    fun `Happy pass - find max in a list with only 0 elements`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(0,0,0,0,0,0,0,0,0,0))
        assertEquals(0, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(0,0,0,0,0,0,0,0,0,0))
        assertEquals(0, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(0,0,0,0,0,0,0,0,0,0))
        assertEquals(0, result3)
    }

    @Test
    fun `Happy pass - find max in a list with only negative elements`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf(-14,-2,-35,-9,-47,-101,-7,-12,-1,-63))
        assertEquals(-1, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf(-14,-2,-35,-9,-47,-101,-7,-12,-1,-63))
        assertEquals(-1, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf(-14,-2,-35,-9,-47,-101,-7,-12,-1,-63))
        assertEquals(-1, result3)
    }

    @Test
    fun `Negative pass - the list is empty`() {
        val maxElement = MaxElement()

        val result = maxElement.findMaxElementByArray(listOf())
        assertEquals(null, result)

        val result2 = maxElement.findMaxElementByArrayPassingTheElementItself(listOf())
        assertEquals(null, result2)

        val result3 = maxElement.findMaxElementByForCycle(listOf())
        assertEquals(null, result3)
    }
}