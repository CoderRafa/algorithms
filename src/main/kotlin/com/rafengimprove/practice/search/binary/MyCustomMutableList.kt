package com.rafengimprove.practice.search.binary

import com.rafengimprove.practice.model.account.Account
import com.rafengimprove.practice.model.account.AccountType

abstract class MyCustomMutableList(val list: MutableList<Account>) : MutableList<Account> by list{
    abstract fun maxAmountAccount(): Account
    abstract fun minAmountAccount(): Account
    abstract fun getAccountsWithCertainType(type: AccountType): List<Account>
    abstract fun getAllAccountsAmountSum(): Double
}