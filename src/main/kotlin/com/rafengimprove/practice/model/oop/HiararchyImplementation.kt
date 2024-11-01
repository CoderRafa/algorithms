package com.rafengimprove.practice.model.oop

open class Bird {
    open fun say() = "I am a bird"

}

open class PredatorBirdImpl() : Bird() {
    override fun say() = "I am a predator bird"

    open fun walk() = "I am walking"
}

open class HawkImpl() : PredatorBirdImpl() {
    override fun say() = "I am a hawk"

    override fun walk() = "I am flying"
}

class MyCustomList<T>(private val list: MutableList<T>) : MutableList<T> by list {

    private var count = 0
    override fun add(element: T): Boolean {
        ++count
        println(count)
        return list.add(element)
    }

    fun count(): Int = count
}


