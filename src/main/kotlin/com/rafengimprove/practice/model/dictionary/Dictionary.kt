package com.rafengimprove.practice.model.dictionary

interface Dictionary<T> {
    fun search(query: String): T
    fun search(predicate: (T)->Boolean): List<T>
}


abstract class AbstractDictionaryImpl<T>(val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {
    override fun search(predicate: (T) -> Boolean): List<T> {
        return list.filter { predicate(it) }
    }
}

class TelephoneDictionary(list: MutableList<Telephone>): AbstractDictionaryImpl<Telephone>(list) {
    override fun search(query: String): Telephone {
        return list.first { it.phone == query }
    }
}

data class Telephone(val phone: String)

class GenericDictionaryImpl<T>(private val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {
    override fun search(query: String): T {
        TODO("Not yet implemented")
    }

    override fun search(predicate: (T) -> Boolean): List<T> {
        TODO("Not yet implemented")
    }

}