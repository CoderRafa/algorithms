package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeSortRecursiveTest {

    @Test
    fun `Happy pass - the list was sorted`() {
        val sortedWithMergeSort = MergeSortRecursive()

        assertEquals(listOf(1,2,3,4,5,6), sortedWithMergeSort.mergeSortRecursive(listOf(5,2,6,3,1,4)))
    }

    @Test
    fun `Negative pass - the list is empty`() {
        val sortedWithMergeSort = MergeSortRecursive()

        assertEquals(listOf<Int>(), sortedWithMergeSort.mergeSortRecursive(listOf()))
    }

    @Test
    fun `Happy pass - the list contains repeating elements`() {
        val sortedWithMergeSort = MergeSortRecursive()

        assertEquals(listOf(1,2,3,3,3,4,5,6), sortedWithMergeSort.mergeSortRecursive(listOf(5,2,3,6,3,1,4,3)))
    }

    @Test
    fun `Happy pass - all elements are the same`() {
        val sortedWithMergeSort = MergeSortRecursive()

        assertEquals(listOf(5,5,5,5,5,5,5,5), sortedWithMergeSort.mergeSortRecursive(listOf(5,5,5,5,5,5,5,5)))
    }

    @Test
    fun `Happy pass - there is a negative element in the list`() {
        val sortedWithMergeSort = MergeSortRecursive()

        assertEquals(listOf(-2,1,3,3,3,4,5,6), sortedWithMergeSort.mergeSortRecursive(listOf(5,-2,3,6,3,1,4,3)))
    }
}