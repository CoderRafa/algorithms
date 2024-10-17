package com.rafengimprove.practice.model.dictionary.impl.abst

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.AbstractDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.Car

class CarDictionaryAbstractImpl(list: MutableList<Car>) : AbstractDictionaryImpl<Car>(list){
    override fun search(query: String): Car {

        if (list.isEmpty()) throw ListIsEmptyException()

        return list.firstOrNull { it.licencePlate == query } ?: throw ElementWasNotFoundException()
    }
}

