package com.rafengimprove.practice.model.dictionary.impl.abst

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.AbstractDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.People

class PeopleDictionaryAbstractImpl(list: MutableList<People>) : AbstractDictionaryImpl<People>(list) {

    override fun search(query: String): People {

        if (list.isEmpty()) throw ListIsEmptyException()

        return list.firstOrNull { it.fullName == query } ?: throw ElementWasNotFoundException()
    }

    override fun search(predicate: (People) -> Boolean): List<People> {

        if (list.isEmpty()) throw ListIsEmptyException()

        if (super.search(predicate).isEmpty()) throw ElementWasNotFoundException()

        return super.search(predicate)
    }
}