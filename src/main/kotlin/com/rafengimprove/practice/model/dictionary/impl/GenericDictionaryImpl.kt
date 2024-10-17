package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.Dictionary
import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.model.DefaultModel


open class GenericDictionaryImpl<T: DefaultModel>(val list: MutableList<T>) : Dictionary<T>, MutableList<T> by list {

    override fun search(query: String): T {

        throwExceptionIfListEmpty(list)

        return list.firstOrNull { it.fieldForSearch() == query } ?: throw ElementWasNotFoundException()
    }

    override fun search(predicate: (T) -> Boolean): List<T> {

        throwExceptionIfListEmpty(list)

        val result = list.filter { predicate(it) }

        if (result.isEmpty()) throw ElementWasNotFoundException()

        return list.filter { predicate(it) }
    }

    private fun throwExceptionIfListEmpty(list: MutableList<T>) {
        if (list.isEmpty()) throw ListIsEmptyException()

    }
}
