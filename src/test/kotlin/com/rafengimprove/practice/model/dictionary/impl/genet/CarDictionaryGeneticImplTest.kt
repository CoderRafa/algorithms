package com.rafengimprove.practice.model.dictionary.impl.genet

import com.rafengimprove.practice.model.dictionary.exceptions.ElementWasNotFoundException
import com.rafengimprove.practice.model.dictionary.exceptions.ListIsEmptyException
import com.rafengimprove.practice.model.dictionary.impl.GenericDictionaryImpl
import com.rafengimprove.practice.model.dictionary.model.Car
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarDictionaryGeneticImplTest {
    
    @Test
    fun `Happy pass - find elements according to given string`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )
        assertEquals("P8734GH", licencePlateNumbers.search("P8734GH").licencePlate)
    }

    @Test
    fun `Happy pass - find elements according to given predicate`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("B9908PK"),
                Car("D4567YU"),
                Car("B9908PK"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("B9908PK")
            )
        )
        assertEquals(4, licencePlateNumbers.search { it.licencePlate.contains("K") }.size)
        assertEquals(4, licencePlateNumbers.search { it.licencePlate.startsWith("B") }.size)
    }

    @Test
    fun `Happy pass - find an element which is the only one in the list`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("F4365HG")
            )
        )

        assertEquals("F4365HG", licencePlateNumbers.search("F4365HG").licencePlate)
        assertEquals(1, licencePlateNumbers.search { !it.licencePlate.contains("B") }.size)
    }

    @Test
    fun `Happy pass - an element is added to the list`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        assertEquals(8, licencePlateNumbers.size)

        licencePlateNumbers.add(Car("Q4861RF"))

        assertEquals(9, licencePlateNumbers.size)
        assertEquals("Q4861RF", licencePlateNumbers.search("Q4861RF").licencePlate)
        assertEquals(1, licencePlateNumbers.search { it.licencePlate.startsWith("Q486") }.size)
    }

    @Test
    fun `Happy pass - an element was deleted from the list`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        assertEquals(8, licencePlateNumbers.size)

        licencePlateNumbers.removeFirst()

        assertEquals(7, licencePlateNumbers.size)

        assertThrows<ElementWasNotFoundException> { licencePlateNumbers.search { it.licencePlate.startsWith("B990") } }
    }

    @Test
    fun `Happy pass - add an element and delete that element`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        assertEquals(8, licencePlateNumbers.size)

        licencePlateNumbers.add(Car("V3324HY"))

        assertEquals(9, licencePlateNumbers.size)

        assertEquals("V3324HY", licencePlateNumbers.search("V3324HY").licencePlate)

        licencePlateNumbers.remove(Car("V3324HY"))

        assertEquals(8, licencePlateNumbers.size)

        assertThrows<ElementWasNotFoundException> { licencePlateNumbers.search("V3324HY") }
    }

    @Test
    fun `Happy pass - the list contains an element`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        Assertions.assertTrue(licencePlateNumbers.contains(Car("D4567YU")))
    }

    @Test
    fun `Negative pass - find a number in an empty list`() {
        val licencePlateNumbers = GenericDictionaryImpl(mutableListOf())

        assertThrows<ListIsEmptyException> { licencePlateNumbers.search("D4567YU") }
    }

    @Test
    fun `Negative pass - find a non existing in list licencePlate number`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        assertThrows<ElementWasNotFoundException> { licencePlateNumbers.search("D9988YU") }
    }

    @Test
    fun `Negative pass - find a deleted number`() {
        val licencePlateNumbers = GenericDictionaryImpl(
            mutableListOf(
                Car("B9908PK"),
                Car("A9317TX"),
                Car("G3381BN"),
                Car("D4567YU"),
                Car("W3421TR"),
                Car("P8734GH"),
                Car("M1278IO"),
                Car("J6523HT")
            )
        )

        licencePlateNumbers.remove(Car("P8734GH"))

        assertThrows<ElementWasNotFoundException> { licencePlateNumbers.search { it.licencePlate.startsWith("P873") } }
    }
}