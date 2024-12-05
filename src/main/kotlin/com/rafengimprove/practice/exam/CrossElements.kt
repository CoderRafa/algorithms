package com.rafengimprove.practice.exam

class CrossElements {
    fun crossElements(list1: List<Int>, list2: List<Int>): Boolean {
        val setList1 = list1.toHashSet()
        val setList2 = list2.toHashSet()

        for (element in setList1) {
            if (list2.contains(element)) return true
        }
        return false
    }
}