package com.rafengimprove.practice.search.binary.impl

import com.rafengimprove.practice.model.account.Account
import com.rafengimprove.practice.model.account.AccountType
import com.rafengimprove.practice.model.exception.MyCustomNotFoundAccountException
import com.rafengimprove.practice.search.binary.MyCustomMutableList

class MyCustomMutableListImpl(list: MutableList<Account> = mutableListOf()) : MyCustomMutableList(list) {
    override fun maxAmountAccount(): Account {
        return list.maxBy { it.amount }
    }

    override fun minAmountAccount(): Account {
        return list.minBy { it.amount }
    }

    override fun getAccountsWithCertainType(type: AccountType): List<Account> {
        return list.filter { it.accountType == type }.also { if (it.isEmpty()) throw MyCustomNotFoundAccountException() }
    }

    override fun getAllAccountsAmountSum(): Double {
        return list.sumOf { it.amount }
    }
}