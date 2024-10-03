package com.rafengimprove.practice.model.dictionary

interface Dictionary<T> {
    fun search(query: String): T
    fun search(predicate: (T)->Boolean): List<T>
}