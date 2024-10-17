package com.rafengimprove.practice.exam

class MergeSortRecursive {

    fun mergeSortRecursive(list: List<Int>): List<Int> {

        if (list.size < 2) return list

        val mid = list.size / 2
        var left = list.subList(0, mid)
        var right = list.subList(mid, list.size)

        return merge(mergeSortRecursive(left), mergeSortRecursive(right))
    }

    fun merge(
        left: List<Int>,
        right: List<Int>,
        leftIndex: Int = 0,
        rightIndex: Int = 0,
        sortedList: MutableList<Int> = mutableListOf<Int>()
    ): List<Int> {
        if (left[leftIndex] < right[rightIndex]) {
            sortedList.add(left[leftIndex])
            if (leftIndex == left.size - 1) {
                sortedList.addAll(right.subList(rightIndex, right.size))
            } else {
                merge(left, right, leftIndex + 1, rightIndex, sortedList)
            }
        } else {
            sortedList.add(right[rightIndex])
            if (rightIndex == right.size - 1) {
                sortedList.addAll(left.subList(leftIndex, left.size))
            } else {
                merge(left, right, leftIndex, rightIndex + 1, sortedList)
            }
        }
        return sortedList
    }
}