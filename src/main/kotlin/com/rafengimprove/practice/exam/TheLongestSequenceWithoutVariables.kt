package com.rafengimprove.practice.exam

class TheLongestSequenceWithoutVariables {

    fun theLongestSequence(list: List<Int>): Int {
        if (list.isEmpty()) return 0

        val result = list.fold(Pair(0,0)) { currentAndMaxLength, number ->
            if (number == 1) {
                Pair(currentAndMaxLength.first + 1, currentAndMaxLength.second)
            } else {
                Pair(0, maxOf(currentAndMaxLength.first, currentAndMaxLength.second))
            }
        }.let {
            maxOf(it.first, it.second)
        }

        return result
    }
}