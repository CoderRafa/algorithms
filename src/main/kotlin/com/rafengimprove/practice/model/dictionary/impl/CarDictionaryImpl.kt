package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.exceptions.AnElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.TheListIsEmptyException
import com.rafengimprove.practice.model.dictionary.model.Car
import com.rafengimprove.practice.model.dictionary.model.Telephone

class CarDictionaryImpl(list: MutableList<Car>) : AbstractDictionaryImpl<Car>(list){
    override fun search(query: String): Car {

        if (list.isEmpty()) throw TheListIsEmptyException()

        return list.firstOrNull { it.licencePlate == query } ?: throw AnElementWasNotFoundException()
    }

    override fun search(predicate: (Car) -> Boolean): List<Car> {

        if (list.isEmpty()) throw TheListIsEmptyException()

        if (super.search(predicate).isEmpty()) throw AnElementWasNotFoundException()

        return super.search(predicate)
    }
}

