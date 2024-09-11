package com.rafengimprove.practice.search.binary

class BinarySearchList<T>(private val mutableList: MutableList<T>, private val comparator: Comparator<T>) :
    MutableList<T> by mutableList {

    init {
        if (mutableList.size > 0) {
            mutableList.sortWith(comparator)
        }
    }

    fun search(predicate: (T)->Int): List<T> {

        var low = 0
        var high = mutableList.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = mutableList[mid]

            when {
                predicate(midVal) == 0 -> return checkForDuplicates(mid, predicate)
                predicate(midVal) < 0 -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return emptyList()
    }

    private fun checkForDuplicates(
        mid: Int, predicate: (T) -> Int
    ): List<T> {
        val allElements = mutableListOf<T>()
        var beginningOfInterval = mid

        while (beginningOfInterval - 1 >= 0 && predicate(mutableList[beginningOfInterval - 1]) == 0 ) {
            beginningOfInterval -= 1
        }

        do {
            allElements.add(mutableList[beginningOfInterval])
            if(beginningOfInterval < mutableList.size -1) {
                beginningOfInterval += 1
            } else {
                break
            }

        } while (predicate(mutableList[beginningOfInterval]) == 0)
        return allElements
    }

    override fun add(element: T): Boolean {
        val result = mutableList.add(element)
        if (result) {
            mutableList.sortWith(comparator)
        }
        return result
    }
}


