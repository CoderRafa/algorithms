package com.rafengimprove.practice.model.account

class MyCustomMutableListClass(val list: MutableList<Account> = mutableListOf()) : MyCustomMutableList,
    MutableList<Account> by list {
    override fun maxAmountAccount(): Account {
        val maxAmount = list.maxOfOrNull { it.amount }
        val listWithTheBiggestAmountAccount = list.filter { it.amount == maxAmount }
        return listWithTheBiggestAmountAccount[0]
    }

    override fun minAmountAccount(): Account {
        val minAmount = list.minOfOrNull { it.amount }
        val listWithTheSmallestAmountAccount = list.filter { it.amount == minAmount }
        return listWithTheSmallestAmountAccount[0]
    }

    override fun getAccountsWithCertainType(type: AccountType): List<Account> {
        return list.filter { it.accountType == type }
    }

    override fun getAllAccountsAmountSum(): Double {
        return list.sumOf { it.amount }
    }
}