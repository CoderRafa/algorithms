package com.rafengimprove.practice.search

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TheLongestSequenceWithFold {

    fun theLongestSequence(list: List<Int>): Int {
        if (list.isEmpty()) return 0

        val result = list.fold(Pair(0, 0)) { currentLength, number ->
            if (number == 1) {
                Pair(currentLength.first + 1, currentLength.second)
            } else {
                if (currentLength.first > currentLength.second) {
                    Pair(0, currentLength.first)
                } else {
                    Pair(0, currentLength.second)
                }
            }
        }.also {
            if (it.first > it.second) {
                return it.first
            }
        }

        return result.second
    }

    @Test
    fun `Happy pass - the longest sequence was found`() {
        assertEquals(5, theLongestSequence(listOf(1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1)))
    }

    @Test
    fun `Happy pass - all elements are 1`() {
        assertEquals(10, theLongestSequence(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun `Negative pass - all elements are 0`() {
        assertEquals(0, theLongestSequence(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
    }

    @Test
    fun `Negative pass - the list is empty`() {
        assertEquals(0, theLongestSequence(listOf()))
    }

    @Test
    fun `Happy pass - the is only one 1 at the beginning`() {
        assertEquals(1, theLongestSequence(listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
    }
}


