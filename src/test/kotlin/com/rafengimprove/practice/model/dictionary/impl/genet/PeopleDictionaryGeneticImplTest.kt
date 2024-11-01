package com.rafengimprove.practice.model.dictionary.impl.genet

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.GenericDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.People
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PeopleDictionaryImplTest {
    @Test
    fun `Happy pass - find elements according to given string`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )
        assertEquals("Will Smith", people.search("Will Smith").fullName)
    }

    @Test
    fun `Happy pass - find elements according to given predicate`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )
        assertEquals(4, people.search { it.fullName.contains("a") }.size)
        assertEquals(2, people.search { it.fullName.startsWith("A") }.size)
    }

    @Test
    fun `Happy pass - find an element which is the only one in the list`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("12345678")
            )
        )

        assertEquals("12345678", people.search("12345678").fullName)
        assertEquals(1, people.search { !it.fullName.contains("9") }.size)
    }

    @Test
    fun `Happy pass - an element is added to the list`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        assertEquals(8, people.size)

        people.add(People("George Clooney"))

        assertEquals(9, people.size)
        assertEquals("George Clooney", people.search("George Clooney").fullName)
        assertEquals(1, people.search { it.fullName.startsWith("Geor") }.size)
    }

    @Test
    fun `Happy pass - an element was deleted from the list`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        assertEquals(8, people.size)

        people.removeFirst()

        assertEquals(7, people.size)

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { people.search { it.fullName.startsWith("Andrey") } }
    }

    @Test
    fun `Happy pass - add an element and delete that element`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        assertEquals(8, people.size)

        people.add(People("Brad Pit"))

        assertEquals(9, people.size)

        assertEquals("Brad Pit", people.search("Brad Pit").fullName)

        people.remove(People("Brad Pit"))

        assertEquals(8, people.size)

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { people.search("Brad Pit") }
    }

    @Test
    fun `Happy pass - the list contains an element`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        kotlin.test.assertTrue(people.contains(People("Drew Berrimor")))
    }

    @Test
    fun `Negative pass - find a person in an empty list`() {
        val people = GenericDictionaryImpl(mutableListOf())

        org.junit.jupiter.api.assertThrows<ListIsEmptyException> { people.search("George Clooney") }
    }

    @Test
    fun `Negative pass - find a non existing in list fullName number`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { people.search("George Clooney") }
    }

    @Test
    fun `Negative pass - find a deleted person`() {
        val people = GenericDictionaryImpl(
            mutableListOf(
                People("Andrey Rogov"),
                People("Robert DeNiro"),
                People("Al Pacino"),
                People("Drew Berrimor"),
                People("Wiliam Saroyan"),
                People("Will Smith"),
                People("Martin Lawrence"),
                People("Dastin Hoffman")
            )
        )

        people.remove(People("Will Smith"))

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { people.search { it.fullName.startsWith("Will") } }
    }
}