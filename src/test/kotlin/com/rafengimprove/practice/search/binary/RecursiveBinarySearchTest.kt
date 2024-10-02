package com.rafengimprove.practice.search.binary

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RecursiveBinarySearchTest {

    @Test
    fun `Happy pass - an element was added in front of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val sizeBeforeAdding = recursiveBinary.size
        recursiveBinary.add(1)
        val sizeAfterAdding = recursiveBinary.size
        val foundIndex = recursiveBinary.find(1)
        val sizeDifference = sizeAfterAdding - sizeBeforeAdding
        assertEquals(1, sizeDifference)
        assertEquals(0, foundIndex)
    }

    @Test
    fun `Happy pass - an element was added in the middle of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,1))
        val sizeBeforeAdding = recursiveBinary.size
        recursiveBinary.add(6)
        val sizeAfterAdding = recursiveBinary.size
        val foundIndex = recursiveBinary.find(6)
        val sizeDifference = sizeAfterAdding - sizeBeforeAdding
        assertEquals(1, sizeDifference)
        assertEquals(5, foundIndex)
    }

    @Test
    fun `Happy pass - an element was added at the end of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,1))
        val sizeBeforeAdding = recursiveBinary.size
        recursiveBinary.add(10)
        val sizeAfterAdding = recursiveBinary.size
        val foundIndex = recursiveBinary.find(10)
        val sizeDifference = sizeAfterAdding - sizeBeforeAdding
        assertEquals(1, sizeDifference)
        assertEquals(8, foundIndex)
    }

    @Test
    fun `Happy pass - given element is found`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val index = recursiveBinary.find(4)
        assertEquals(2, index)
    }

    @Test
    fun `Happy pass - an element was deleted from the beginning of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val sizeBeforeDeleting = recursiveBinary.size
        recursiveBinary.remove(2)
        val sizeAfterDeleting = recursiveBinary.size
        assertEquals(1, sizeBeforeDeleting - sizeAfterDeleting)
        assertEquals(null, recursiveBinary.find(2))
    }

    @Test
    fun `Happy pass - an element was deleted from the middle of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val sizeBeforeDeleting = recursiveBinary.size
        recursiveBinary.remove(7)
        val sizeAfterDeleting = recursiveBinary.size
        assertEquals(1, sizeBeforeDeleting - sizeAfterDeleting)
        assertEquals(null, recursiveBinary.find(7))
    }

    @Test
    fun `Happy pass - an element was deleted from the end of the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val sizeBeforeDeleting = recursiveBinary.size
        recursiveBinary.remove(9)
        val sizeAfterDeleting = recursiveBinary.size
        assertEquals(1, sizeBeforeDeleting - sizeAfterDeleting)
        assertEquals(null, recursiveBinary.find(9))
    }

    @Test
    fun `Happy pass - find an element in a list with just one element and return null after deleting it`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2))
        val index = recursiveBinary.find(2)
        assertEquals(0, index)
        recursiveBinary.remove(2)
        val indexAfterDeleting = recursiveBinary.find(2)
        assertEquals(null, indexAfterDeleting)
    }

    @Test
    fun `Happy pass - find the element in a list which consists only that element and several of them`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2, 2, 2, 2, 2, 2, 2))
        val index = recursiveBinary.find(2)
        assertEquals(3, index)
    }
    @Test
    fun `Negative pass - given element is not found`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val index = recursiveBinary.find(12)
        assertEquals(null, index)
    }

    @Test
    fun `Negative pass - try to find an element in an empty list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf())
        val index = recursiveBinary.find(1)
        assertEquals(null, index)
    }
    @Test
    fun `Negative pass - an element to be deleted is not present in the list`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,6))
        val sizeBeforeDeleting = recursiveBinary.size
        recursiveBinary.remove(12)
        val sizeAfterDeleting = recursiveBinary.size
        assertEquals(sizeBeforeDeleting, sizeAfterDeleting)
    }

    @Test
    fun `Negative pass - an element to be added already exists in the list and is not added`() {
        val recursiveBinary = RecursiveBinarySearch(mutableListOf(2,3,5,7,8,9,4,1))
        val sizeBeforeAdding = recursiveBinary.size
        recursiveBinary.add(8)
        val sizeAfterAdding = recursiveBinary.size
        assertEquals(sizeBeforeAdding, sizeAfterAdding)
    }
}