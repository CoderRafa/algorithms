package com.rafengimprove.practice.search.binary

interface RecursiveBinary {
    fun find(element: Int, list: List<Int>? = null): Int?
}

class RecursiveBinarySearch(private val list: MutableList<Int> = mutableListOf()) : RecursiveBinary,
    MutableList<Int> by list {
    override fun add(element: Int): Boolean {
        return list.add(element)
    }

    override fun remove(element: Int): Boolean {
        return list.remove(element)
    }

    override fun contains(element: Int): Boolean {
        return list.contains(element)
    }

    override val size: Int
        get() = list.size

    override fun find(element: Int, list: List<Int>?): Int? {
        return if (list == null) find(element, this.list)
        else if (list.isEmpty()) null
        else {
            val mid = list.size / 2
            if (list[mid] == element) {
                println("We have found the element")
                mid
            } else if (list[mid] < element) {
                println(list.subList(mid + 1, list.size).map { it.toString() })
                find(element, list.subList(mid + 1, list.size))
            } else {
                println(list.subList(0, mid).map { it.toString() })
                find(element, list.subList(0, mid))
            }
        }
    }
}