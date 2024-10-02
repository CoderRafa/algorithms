package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RecursiveMergeSortKtTest {

   @Test
   fun `Happy pass - a list with less than two elements was returned as a result`() {
        val sortedList = mergeSort(listOf(2))
        assertEquals(2, sortedList[0])
   }

    @Test
    fun `Negative pass - when passed an empty list as a result it returns that empty list`() {
        val sortedList = mergeSort(listOf())
        assertTrue(sortedList.isEmpty())
    }

    @Test
    fun `Happy pass - sort the list with mergeSort`() {
        val sortedList = mergeSort(listOf(2,5,3,4,1,6,8,7))
        assertEquals(1, sortedList[0])
        assertEquals(4, sortedList[3])
        assertEquals(8, sortedList[7])
    }

    @Test
    fun `Happy pass - sort the list with the same elements with mergeSort`() {
        val sortedList = mergeSort(listOf(2,2,2,2,2,2,2,2))
        assertEquals(2, sortedList[0])
        assertEquals(2, sortedList[3])
        assertEquals(2, sortedList[7])
    }

    @Test
    fun `Happy pass - sort the list with zeros with mergeSort`() {
        val sortedList = mergeSort(listOf(0,0,0,0,0,0,0,0))
        assertEquals(0, sortedList[0])
        assertEquals(0, sortedList[3])
        assertEquals(0, sortedList[7])
    }
}