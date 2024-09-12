package com.rafengimprove.practice.collection

import com.rafengimprove.practice.collection.BinaryTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class TreeMapTest {

    @Test
    fun `Happy pass - try to add some values to a TreeMap`() {
        val treeMap = BinaryTree(listOf(0, 1, 2, 3, 4, 5, 6))
        assertEquals(7, treeMap.size())
    }
}