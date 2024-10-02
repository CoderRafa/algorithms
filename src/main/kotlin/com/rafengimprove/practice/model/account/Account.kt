package com.rafengimprove.practice.model.account

data class Account(
    val number: String,
    val amount: Double,
    val fullName: String,
    val accountType: AccountType
)
