package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.exceptions.AnElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.TheListIsEmptyException
import com.rafengimprove.practice.model.dictionary.model.Telephone

class TelephoneDictionaryImpl(list: MutableList<Telephone>) : AbstractDictionaryImpl<Telephone>(list) {
    override fun search(query: String): Telephone {

        if (list.isEmpty()) throw TheListIsEmptyException()

        return list.firstOrNull { it.phone == query } ?: throw AnElementWasNotFoundException()
    }

    override fun search(predicate: (Telephone) -> Boolean): List<Telephone> {

        if (list.isEmpty()) throw TheListIsEmptyException()
        if (super.search(predicate).isEmpty()) throw AnElementWasNotFoundException()

        return super.search(predicate)
    }
}