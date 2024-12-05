package com.rafengimprove.practice.exam

class MaxElement {
    fun findMaxElementByArray(list: List<Byte>): Byte? {
        if (list.isEmpty()) return null
        val arrayList = MutableList<Byte>(256) { 0 }
        for (element in list) {
            arrayList[128 + element] = 1
        }
        for (element in arrayList.size - 1 downTo 0) {
            if (arrayList[element] == 1.toByte()) {
                return (element - 128).toByte()
            }
        }
        return null
    }

    fun findMaxElementByArrayPassingTheElementItself(list: List<Byte>): Byte? {
        if (list.isEmpty()) return null
        val arrayList = MutableList(256) { 0 }
        for (element in list) {
            if (element == 0.toByte()) {
                arrayList[128] = 1
            } else {
                arrayList[128 + element] = element.toInt()
            }
        }
        for (index in arrayList.size - 1 downTo 0) {
            if (arrayList[index] != 0) {
                return if (index == 128) {
                    0
                } else {
                    arrayList[index].toByte()
                }
            }
        }
        return null
    }

    fun findMaxElementByForCycle(list: List<Byte>): Byte? {
        if (list.isEmpty()) return null
        var maxElement: Byte = -128

        for (element in list) {
            if (element > maxElement){
                maxElement = element
            }
        }
        return maxElement
    }
}