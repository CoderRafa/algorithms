package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RecursiveBinarySearchTest {

    @Test
    fun add() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun contains() {
    }

    @Test
    fun size() {
    }

    @Test
    fun find() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val index = recursiveBinary.find(12)
        assertEquals(null, index)
    }
}