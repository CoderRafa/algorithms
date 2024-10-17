package com.rafengimprove.practice.model.dictionary.impl.abst

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.AbstractDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.Telephone

class TelephoneDictionaryAbstractImpl(list: MutableList<Telephone>) : AbstractDictionaryImpl<Telephone>(list) {
    override fun search(query: String): Telephone {

        if (list.isEmpty()) throw ListIsEmptyException()

        return list.firstOrNull { it.phone == query } ?: throw ElementWasNotFoundException()
    }

    override fun search(predicate: (Telephone) -> Boolean): List<Telephone> {

        if (list.isEmpty()) throw ListIsEmptyException()
        if (super.search(predicate).isEmpty()) throw ElementWasNotFoundException()

        return super.search(predicate)
    }
}