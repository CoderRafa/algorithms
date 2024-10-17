package com.rafengimprove.practice.model.dictionary.model

data class People(val fullName: String) : DefaultModel {
    override fun fieldForSearch(): String {
        return fullName
    }

}
