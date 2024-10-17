package com.rafengimprove.practice.model.dictionary.model

data class Car(val licencePlate: String) : DefaultModel {
    override fun fieldForSearch(): String {
        return licencePlate
    }
}