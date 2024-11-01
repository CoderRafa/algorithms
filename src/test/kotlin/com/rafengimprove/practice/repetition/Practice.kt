package com.rafengimprove.practice.repetition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Practice {
    fun recBinar(
        list: MutableList<Int>,
        target: Int,
        low: Int = 0,
        high: Int = list.size - 1
    ): Int? {

        if (list.size < 2) return null

        var changeableLow = low
        var changeableHigh = high

        list.sort()

        val mid = (low + high) / 2

        when {
            list[mid] == target -> return mid
            list[mid] > target -> changeableHigh = mid - 1
            else -> changeableLow = mid + 1
        }

        if (changeableLow <= changeableHigh) {
            recBinar(list, target, changeableLow, changeableHigh)
        }

        return null
    }

    @Test
    fun `Check the recursive binary search`() {
        val result = recBinar(mutableListOf(5,2,1,9,3,4,7,6), 7)
        assertEquals(8, result)
    }

}