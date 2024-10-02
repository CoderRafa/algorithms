package com.rafengimprove.practice.search.binary

import com.rafengimprove.practice.model.account.Account
import com.rafengimprove.practice.model.account.AccountType.*
import com.rafengimprove.practice.search.binary.impl.MyCustomMutableListImpl
import com.rafengimprove.practice.model.exception.MyCustomNotFoundAccountException
import com.rafengimprove.practice.model.exception.UnableToDoAnOperationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class AccountCollectionTest {

    private fun listOfAccounts(list: MutableList<Account>? = null): MyCustomMutableList {
        var listToAlter = list
        if (listToAlter == null) {
            listToAlter =  mutableListOf(
                Account("1", 125.0, "Leroy Smith", BUSINESS),
                Account("2", 85.5, "Jenny Jons", CURRENT),
                Account("3", 52.0, "Bob Smith", BUSINESS),
                Account("4", 41.0, "Mike Smith", SAVING),
                Account("5", 33.0, "Danny Smith", BUSINESS),
                Account("6", 92.0, "Sue Smith", CURRENT)
            )
        }
        return MyCustomMutableListImpl(listToAlter)
    }

    @Test
    fun `Happy pass - find an account with max amount`() {
        val customCollection = listOfAccounts()

        assertEquals(125.0, customCollection.maxAmountAccount().amount)
    }

    @Test
    fun `Happy pass - find an account with min amount`() {
        val customCollection = listOfAccounts()
        assertEquals(33.0, customCollection.minAmountAccount().amount)

    }

    @Test
    fun `Happy pass - find accounts with a certain type`() {
        val customCollection = listOfAccounts()

        assertEquals(3, customCollection.getAccountsWithCertainType(BUSINESS).size)
    }

    @Test
    fun `Happy pass - calculate the sum off all accounts`() {
        val customCollection = listOfAccounts()

        assertEquals(428.0, customCollection.getAllAccountsAmountSum())
    }

    @Test
    fun `Negative pass - get max in an empty list`() {
        val customCollection = listOfAccounts(mutableListOf())

        assertThrows<MyCustomNotFoundAccountException> { customCollection.maxAmountAccount() }
    }

    @Test
    fun `Negative pass - get min in an empty list`() {
        val customCollection = listOfAccounts(mutableListOf())

        assertThrows<MyCustomNotFoundAccountException> { customCollection.minAmountAccount() }
    }

    @Test
    fun `Negative pass - get a list of accounts of a certain type from an empty list`() {
        val customCollection = listOfAccounts(mutableListOf())

        assertThrows<MyCustomNotFoundAccountException> { customCollection.getAccountsWithCertainType(BUSINESS) }
    }

    @Test
    fun `Negative pass - call sum method on an empty list`() {
        val customCollection = listOfAccounts(mutableListOf())

        assertThrows<UnableToDoAnOperationException> { customCollection.getAllAccountsAmountSum() }
    }
}