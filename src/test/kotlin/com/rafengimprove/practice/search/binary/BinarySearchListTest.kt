package com.rafengimprove.practice.search.binary

import com.rafengimprove.practice.model.Person
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class BinarySearchListTest {

    private fun getPredicateBy(name: String) = { person: Person -> person.name.compareTo(name) }
    private fun getPredicateBy(age: Int) = { person: Person -> person.age.compareTo(age) }

    @Test
    @Order(5)
    fun `Happy pass - search finds the element`() {
        val alice = Person("Alice", 30)
        val charlie = Person("Charlie", 35)
        val binarySearch = BinarySearchList(mutableListOf(
            alice,
            Person("Bob", 25),
            charlie,
            Person("Alice", 25)
        ), Comparator<Person> { p1, p2 -> p1.age.compareTo(p2.age) })
        val people = binarySearch.search(getPredicateBy(35))

        assertEquals(people.size, 1)
        assertEquals(people[0], charlie)
    }

    @Test
    @Order(10)
    fun `Happy pass - add elements in an empty mutable list and then search and find an element from the list`() {
        val binarySearchList =
            BinarySearchList(mutableListOf(), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val bob = Person("Bob", 25)

        binarySearchList.add(bob)

        assertEquals(binarySearchList.size, 1)

        val alex = Person("Alex", 32)

        binarySearchList.add(alex)

        assertEquals(binarySearchList.size, 2)

        binarySearchList.add(Person("Sandra", 27))

        assertEquals(binarySearchList.size, 3)

        val people = binarySearchList.search(getPredicateBy("Alex"))

        assertEquals(people.size, 1)
        assertEquals(people[0], alex)
    }

    @Test
    @Order(15)
    fun `Happy pass - finds an element at the beginning of the list`() {
        val binarySearch = BinarySearchList(mutableListOf(
            Person("Greg", 25),
            Person("Charlie", 35),
            Person("Bob", 25),
            Person("Dylan", 52),
            Person("Alice", 30),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Alice"))
        assertEquals(people[0].name, "Alice")
        assertEquals(people.size, 1)
        assertEquals(people[0].age, 30)
    }

    @Test
    @Order(20)
    fun `Happy pass - finds an element in the middle of the list`() {
        val binarySearch = BinarySearchList(mutableListOf(
            Person("Greg", 25),
            Person("Charlie", 35),
            Person("Bob", 25),
            Person("Dylan", 52),
            Person("Alice", 30),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Charlie"))
        assertEquals(people[0].name, "Charlie")
        assertEquals(people.size, 1)
        assertEquals(people[0].age, 35)
    }

    @Test
    @Order(25)
    fun `Happy pass - finds an element at the end of the list`() {
        val binarySearch = BinarySearchList(mutableListOf(
            Person("Greg", 25),
            Person("Charlie", 35),
            Person("Bob", 25),
            Person("Dylan", 52),
            Person("Alice", 30),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Greg"))
        assertEquals(people[0].name, "Greg")
        assertEquals(people.size, 1)
        assertEquals(people[0].age, 25)
    }

    @Test
    @Order(30)
    fun `Happy pass - added multiple occurrences of the predicate`() {

        val binarySearch = BinarySearchList(mutableListOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35),
            Person("Alice", 25),
            Person("Alice", 52),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Alice"))

        assertEquals(3, people.size)
        assertTrue(people.all { it.name == "Alice" })
    }

    @Test
    @Order(35)
    fun `Happy pass - find multiple occurrences in the middle of the list`() {
        val binarySearch = BinarySearchList(mutableListOf(
            Person("Alice", 30),
            Person("Bob", 35),
            Person("Bob", 25),
            Person("Charlie", 25),
            Person("Bob", 52),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Bob"))
        assertEquals(3, people.size)
        assertTrue(people.all { it.name == "Bob" })
    }

    @Test
    @Order(40)
    fun `Happy pass - find multiple occurrences at the end of the list`() {
        val binarySearch = BinarySearchList(mutableListOf(
            Person("Alice", 30),
            Person("Charlie", 35),
            Person("Bob", 25),
            Person("Charlie", 25),
            Person("Barbara", 52),
            Person("Charlie", 52),
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Charlie"))
        assertEquals(3, people.size)
        assertTrue(people.all { it.name == "Charlie" })
    }

    @Test
    @Order(45)
    fun `Happy pass - find an element in a list where all are the same`() {
        val binarySearchList = BinarySearchList(
            (mutableListOf(
                Person("Alice", 25),
                Person("Alice", 25),
                Person("Alice", 25)
            ))
        ) { p1, p2 -> p1.name.compareTo(p2.name) }

        val people = binarySearchList.search(getPredicateBy("Alice"))

        assertEquals(people.size, 3)
        assertTrue(people.all { it.name == "Alice" })
        assertTrue(people.all { it.age == 25 })
    }

    @Test
    @Order(50)
    fun `Negative pass - returns null when the element doesn't exist in the list`() {

        val binarySearch = BinarySearchList(mutableListOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35),
            Person("Alice", 25)
        ), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearch.search(getPredicateBy("Mike"))

        assertTrue(people.isEmpty())
    }

    @Test
    @Order(55)
    fun `Negative pass - returns null when we try to search in an empty mutable list`() {
        val binarySearchList =
            BinarySearchList(mutableListOf(), Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) })

        val people = binarySearchList.search(getPredicateBy("Alice"))

        assertTrue(people.isEmpty())
    }

    @Test
    @Order(60)
    fun `Negative pass - don't find an element that don't exist in a list with the same elements`() {
        val binarySearchList = BinarySearchList(
            mutableListOf(
                Person("Alice", 25),
                Person("Alice", 25),
                Person("Alice", 25),
            )
        ) { p1, p2 ->
            p1.name.compareTo(p2.name)
        }

        val people = binarySearchList.search(getPredicateBy("Mark"))

        assertTrue(people.isEmpty())
    }
}