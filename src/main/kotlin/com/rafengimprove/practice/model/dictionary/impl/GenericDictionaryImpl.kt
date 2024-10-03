package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.Dictionary


open class GenericDictionaryImpl<T>(val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {
    override fun search(query: String): T {
        TODO("Not yet implemented")
    }

    override fun search(predicate: (T) -> Boolean): List<T> {
        return list.filter { predicate(it) }
    }
}