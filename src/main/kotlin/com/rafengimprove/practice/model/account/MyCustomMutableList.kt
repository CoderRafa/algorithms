package com.rafengimprove.practice.model.account

interface MyCustomMutableList : MutableList<Account> {
    fun maxAmountAccount(): Account
    fun minAmountAccount(): Account
    fun getAccountsWithCertainType(type: AccountType): List<Account>
    fun getAllAccountsAmountSum(): Double
}