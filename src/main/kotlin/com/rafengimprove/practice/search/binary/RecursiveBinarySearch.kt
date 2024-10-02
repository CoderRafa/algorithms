package com.rafengimprove.practice.search.binary

interface RecursiveBinary {
    fun find(element: Int, list: List<Int>? = null, offset: Int = 0): Int?
}

class RecursiveBinarySearch(private val list: MutableList<Int> = mutableListOf()) : RecursiveBinary,
    MutableList<Int> by list {

    init {
        list.sort()
    }

    override fun add(element: Int): Boolean {
        var result = false
        if (find(element, this.list) == null) {
            list.add(element)
            list.sort()
            result = true
        }
        return result
    }

    override fun find(element: Int, list: List<Int>?, offset: Int): Int? {

        return if (list == null) find(element, this.list)
        else if (list.isEmpty()) null
        else {

            val mid = list.size / 2
            if (list[mid] == element) {
                println("The offset is $offset the mid is $mid index is ${offset + mid}")
                offset + mid
            } else if (list[mid] < element) {
                println("The index is ${offset + mid + 1}")
                println("The list now is ${list.subList(mid + 1, list.size).map { it.toString() }}")
                find(element, list.subList(mid + 1, list.size), offset + mid + 1)
            } else {
                println("The index is $offset")
                println("The list now is ${list.subList(0, mid).map { it.toString() }}")
                find(element, list.subList(0, mid), offset)
            }
        }
    }
}