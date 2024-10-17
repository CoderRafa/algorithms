package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.Dictionary
import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException

abstract class AbstractDictionaryImpl<T>(val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {
    override fun search(predicate: (T) -> Boolean): List<T> {

        if (list.isEmpty()) throw ListIsEmptyException()

        val result = list.filter { predicate(it) }
        if (result.isEmpty()) throw ElementWasNotFoundException()

        return result
    }
}