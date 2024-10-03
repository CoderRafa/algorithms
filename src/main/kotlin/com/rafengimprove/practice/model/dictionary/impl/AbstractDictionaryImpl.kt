package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.Dictionary

abstract class AbstractDictionaryImpl<T>(val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {
    override fun search(predicate: (T) -> Boolean): List<T> {
        return list.filter { predicate(it) }
    }
}