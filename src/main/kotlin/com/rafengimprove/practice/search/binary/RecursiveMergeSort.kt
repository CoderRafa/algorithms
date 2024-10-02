package com.rafengimprove.practice.search.binary

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list

    val mid = list.size / 2
    val left = list.subList(0, mid)
    val right = list.subList(mid, list.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>, sortedList: MutableList<Int> = mutableListOf(), leftIndex: Int = 0, rightIndex: Int = 0): List<Int> {
    var passedLeftIndex = leftIndex
    var passedRightIndex = rightIndex

    if (left[leftIndex] < right[rightIndex]) {
        sortedList.add(left[leftIndex])
        if (leftIndex == left.size - 1) {
            sortedList.addAll(right.subList(rightIndex, right.size))
            return sortedList
        }
        return merge(left, right, sortedList, leftIndex = ++passedLeftIndex, rightIndex)
    } else {
        sortedList.add(right[rightIndex])
        if (rightIndex == right.size - 1) {
            sortedList.addAll(left.subList(leftIndex, left.size))
            return sortedList
        }
        return merge(left, right, sortedList, leftIndex, rightIndex = ++passedRightIndex)
    }
}
