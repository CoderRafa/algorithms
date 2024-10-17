package com.rafengimprove.practice.model.dictionary.model

data class Telephone(val phone: String) : DefaultModel {
    override fun fieldForSearch(): String {
        return phone
    }

}