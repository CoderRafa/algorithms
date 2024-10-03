package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.exceptions.AnElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.TheListIsEmptyException
import com.rafengimprove.practice.model.dictionary.model.People

class PeopleDictionaryImpl(list: MutableList<People>) : AbstractDictionaryImpl<People>(list) {

    override fun search(query: String): People {

        if (list.isEmpty()) throw TheListIsEmptyException()

        return list.firstOrNull { it.fullName == query } ?: throw AnElementWasNotFoundException()
    }

    override fun search(predicate: (People) -> Boolean): List<People> {

        if (list.isEmpty()) throw TheListIsEmptyException()

        if (super.search(predicate).isEmpty()) throw AnElementWasNotFoundException()

        return super.search(predicate)
    }
}