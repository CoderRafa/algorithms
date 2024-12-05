package com.rafengimprove.practice.model.oop.generic

import com.rafengimprove.practice.model.oop.generic.Key.*

open class Writing(
    val letter: Char? = null,
    val action: Key
)

enum class Key {
    LOWER_CASE, UPPER_CASE, SPACE, DELETE
}

interface Type<T: Writing> {
    fun type(writing: T, string: StringBuilder): StringBuilder

    fun key(): Key
}

class TypingServiceManager(private val keys: List<Type<Writing>>) {

    private val pressedKey: Map<Key, List<Type<Writing>>> = keys.groupBy { it.key() }
    fun type(string: StringBuilder, writing: Writing): StringBuilder {
        pressedKey[writing.action]?.map { it.type(writing, string) }.also { return it!!.first() }
    }
}

class TypeLowerCase(private val writing: Writing, val string: StringBuilder) : Type<Writing> {
    override fun type(writing: Writing, string: StringBuilder): StringBuilder {
        return string.append(writing.letter)
    }

    override fun key(): Key {
        return LOWER_CASE
    }
}

class TypeUpperCase(private val writing: Writing, val string: StringBuilder) : Type<Writing> {
    override fun type(writing: Writing, string: StringBuilder): StringBuilder {
        return string.append(writing.letter?.uppercaseChar())
    }
    override fun key(): Key {
        return UPPER_CASE
    }
}

class TypeSpace(private val writing: Writing, val string: StringBuilder) : Type<Writing> {
    override fun type(writing: Writing, string: StringBuilder): StringBuilder {
        return string.append(" ")
    }
    override fun key(): Key {
        return SPACE
    }
}

class Delete(private val writing: Writing, val string: StringBuilder) : Type<Writing> {
    override fun type(writing: Writing, string: StringBuilder): StringBuilder {
        return string.deleteAt(string.length - 1)
    }
    override fun key(): Key {
        return DELETE
    }
}