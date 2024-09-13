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
        treeMap.printAll()
    }

    @Test
    fun `Happy pass - init tree and then add more elements`() {
        val treeMap = BinaryTree(listOf(10, 21, 32, 43, 54, 65, 67))
        assertEquals(7, treeMap.size())
        treeMap.add(16)
        treeMap.add(27)
        treeMap.add(57)
        assertEquals(10, treeMap.size())
    }

    @Test
    fun `Happy pass - a tree contains the given element`() {
        val treeMap = BinaryTree(listOf(10, 21, 32, 43, 54, 65, 67))
        assertEquals(true, treeMap.contains(43))
        assertEquals(true, treeMap.contains(32))
        assertEquals(true, treeMap.contains(10))
        assertEquals(true, treeMap.contains(65))
    }

    @Test
    fun `Happy pass - printAll`() {
        val treeMap = BinaryTree(listOf(10, 21, 32, 43, 54, 65, 67))
        treeMap.printAll()
        treeMap.printAll(type = DirectionType.DESC)
    }

    @Test
    fun `Happy pass - node can be null`() {
        val treeMap = BinaryTree(listOf(10, 21, 32, 43, 54, 65, 67))
        val node = treeMap.findNodeForAdding(54)
        assertEquals(54, node.value)
    }
}