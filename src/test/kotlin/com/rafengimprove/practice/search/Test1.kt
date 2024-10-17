package com.rafengimprove.practice.search

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test1 {

    fun theLongestSequence(list: List<Int>): Pair<Int, Int> {
        var maxElement = list[0]
        var currentElement = list[0]
        var currentLength = 1
        var maxLength = 1

        for (i in 1 until list.size) {
            if (list[i] == currentElement) {
               currentLength++
            } else {
                if (currentLength > maxLength) {
                maxLength = currentLength
                maxElement = currentElement
                }
                currentLength = 1
                currentElement = list[i]
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength
            maxElement = currentElement
        }

        return Pair(maxElement, maxLength)
    }

    @Test
    fun `Happy pass - the longest sequence was found`() {
        val result = theLongestSequence(listOf(1,1,1,0,0,1,1,1,1,1,0,0,0,0))

        assertEquals(Pair(1, 5), result)
    }
}