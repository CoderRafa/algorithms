package com.rafengimprove.practice.model.dictionary.impl.genet

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.GenericDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.Telephone
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TelephoneDictionaryImplTest {
    @Test
    fun `Happy pass - find elements according to given string`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )
        assertEquals("331245687", phoneNumbers.search("331245687").phone)
    }

    @Test
    fun `Happy pass - find elements according to given predicate`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )
        assertEquals(5, phoneNumbers.search { it.phone.contains("5") }.size)
        assertEquals(2, phoneNumbers.search { it.phone.startsWith("9") }.size)
    }

    @Test
    fun `Happy pass - find an element which is the only one in the list`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("12345678")
            )
        )

        assertEquals("12345678", phoneNumbers.search("12345678").phone)
        assertEquals(1, phoneNumbers.search { !it.phone.contains("9") }.size)
    }

    @Test
    fun `Happy pass - an element is added to the list`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        assertEquals(8, phoneNumbers.size)

        phoneNumbers.add(Telephone("111111111"))

        assertEquals(9, phoneNumbers.size)
        assertEquals("111111111", phoneNumbers.search("111111111").phone)
        assertEquals(1, phoneNumbers.search { it.phone.startsWith("11") }.size)
    }

    @Test
    fun `Happy pass - an element was deleted from the list`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        assertEquals(8, phoneNumbers.size)

        phoneNumbers.removeFirst()

        assertEquals(7, phoneNumbers.size)

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { phoneNumbers.search { it.phone.startsWith("131") } }
    }

    @Test
    fun `Happy pass - add an element and delete that element`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        assertEquals(8, phoneNumbers.size)

        phoneNumbers.add(Telephone("111222333"))

        assertEquals(9, phoneNumbers.size)

        assertEquals("111222333", phoneNumbers.search("111222333").phone)

        phoneNumbers.remove(Telephone("111222333"))

        assertEquals(8, phoneNumbers.size)

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { phoneNumbers.search("111222333") }
    }

    @Test
    fun `Happy pass - the list contains an element`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        kotlin.test.assertTrue(phoneNumbers.contains(Telephone("231244687")))
    }

    @Test
    fun `Negative pass - find a number in an empty list`() {
        val phoneNumbers = GenericDictionaryImpl(mutableListOf())

        org.junit.jupiter.api.assertThrows<ListIsEmptyException> { phoneNumbers.search("531245888") }
    }

    @Test
    fun `Negative pass - find a non existing in list phone number`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { phoneNumbers.search("531245888") }
    }

    @Test
    fun `Negative pass - find a deleted number`() {
        val phoneNumbers = GenericDictionaryImpl(
            mutableListOf(
                Telephone("131245687"),
                Telephone("931248687"),
                Telephone("931249687"),
                Telephone("231244687"),
                Telephone("231245687"),
                Telephone("331245687"),
                Telephone("431245687"),
                Telephone("531245687")
            )
        )

        phoneNumbers.remove(Telephone("331245687"))

        org.junit.jupiter.api.assertThrows<ElementWasNotFoundException> { phoneNumbers.search { it.phone.startsWith("3312") } }
    }
}