package com.rafengimprove.practice.model.dictionary.impl

import com.rafengimprove.practice.model.dictionary.model.Car

class CarDictionaryImpl(list: MutableList<Car>) : AbstractDictionaryImpl<Car>(list){
    override fun search(query: String): Car {
        return list.first { it.licencePlate == query }
    }
}

