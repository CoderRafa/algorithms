package com.rafengimprove.practice.search.binary

fun recursiveCrossElement(left: List<Int>, right: List<Int>, leftIndex: Int = 0, rightIndex: Int = 0): Boolean {

    if (left.isEmpty() || right.isEmpty()) return false
    if (left.size < 2 && right.size < 2 && left[0] != right[0]) return false

    val sortedLeft = left.sorted()
    val sortedRight = right.sorted()

    var changeableLeftIndex = leftIndex
    var changeableRightIndex = rightIndex

    return if (sortedLeft[changeableLeftIndex] == sortedRight[changeableRightIndex]) {
        true
    } else if (sortedLeft[changeableLeftIndex] < sortedRight[changeableRightIndex]) {
        if (changeableLeftIndex == left.size - 1) {
            false
        } else {
            recursiveCrossElement(sortedLeft, sortedRight, changeableLeftIndex + 1, changeableRightIndex)
        }

    } else {
        if (changeableRightIndex == right.size - 1) {
            false
        } else {
            recursiveCrossElement(sortedLeft, sortedRight, changeableLeftIndex, changeableRightIndex + 1)
        }
    }
}