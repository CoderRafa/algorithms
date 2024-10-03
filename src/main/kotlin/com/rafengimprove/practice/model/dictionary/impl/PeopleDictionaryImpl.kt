package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.model.People

class PeopleDictionaryImpl(list: MutableList<People>) : AbstractDictionaryImpl<People>(list) {

    override fun search(query: String): People {
        return list.first { it.fullName == query }
    }
}