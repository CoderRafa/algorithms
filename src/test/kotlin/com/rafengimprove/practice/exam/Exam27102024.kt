package com.rafengimprove.practice.exam

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

enum class CurrencyType(val rate: Double) {
    USD(0.9), EUR(1.0), RUB(0.01)
}

enum class AscendingType {
    ASC, DESC
}

data class Money(
    val amount: Double,
    val currency: CurrencyType
) {
    operator fun plus(other: Money): Money {
        val value1 = amount * currency.rate
        val value2 = other.amount * other.currency.rate
        return Money(value1 + value2, CurrencyType.EUR)
    }
}


interface MergeSortMoney {
    fun sort(list: List<Money>): List<Money>
    fun merge(firstList: List<Money>, secondList: List<Money>): List<Money>
}

abstract class AbstractMergeSortMoney() : MergeSortMoney {
    override fun sort(list: List<Money>): List<Money> {

        if (list.size < 2) return list

        val mid = list.size / 2

        val firstPart = list.subList(0, mid)
        val secondPart = list.subList(mid, list.size)

        return merge(sort(firstPart), sort(secondPart))
    }
}

class MergeByAscendingMoney() : AbstractMergeSortMoney() {
    override fun merge(firstList: List<Money>, secondList: List<Money>): List<Money> {
        var toContinue = true
        var firstListIndex = 0
        var secondListIndex = 0

        val sortedMoneyList = mutableListOf<Money>()

        while (toContinue) {
            if (firstList[firstListIndex].amount < secondList[secondListIndex].amount) {
                sortedMoneyList.add(firstList[firstListIndex])

                if (firstListIndex == firstList.size - 1) {
                    sortedMoneyList.addAll(secondList.subList(secondListIndex, secondList.size))
                    toContinue = false
                }
                firstListIndex++
            } else {
                sortedMoneyList.add(secondList[secondListIndex])

                if (secondListIndex == secondList.size - 1) {
                    sortedMoneyList.addAll(firstList.subList(firstListIndex, firstList.size))
                    toContinue = false
                }
                secondListIndex++
            }
        }

        return sortedMoneyList
    }
}

class MergeSortDescending() : AbstractMergeSortMoney() {
    override fun merge(firstList: List<Money>, secondList: List<Money>): List<Money> {
        var toContinue = true
        var firstListIndex = 0
        var secondListIndex = 0

        val sortedMoneyList = mutableListOf<Money>()

        while (toContinue) {
            if (firstList[firstListIndex].amount > secondList[secondListIndex].amount) {
                sortedMoneyList.add(firstList[firstListIndex])

                if (firstListIndex == firstList.size - 1) {
                    sortedMoneyList.addAll(secondList.subList(secondListIndex, secondList.size))
                    toContinue = false
                }
                firstListIndex++
            } else {
                sortedMoneyList.add(secondList[secondListIndex])

                if (secondListIndex == secondList.size - 1) {
                    sortedMoneyList.addAll(firstList.subList(firstListIndex, firstList.size))
                    toContinue = false
                }
                secondListIndex++
            }
        }

        return sortedMoneyList
    }
}

fun mergeMoney(sortType: AscendingType, list: List<Money>): List<Money> {
    return if (sortType == AscendingType.ASC) {
        val sortBbyAscending = MergeByAscendingMoney()
        sortBbyAscending.sort(list)
    } else {
        val sortByDescending = MergeSortDescending()
        sortByDescending.sort(list)
    }
}

class Exam27102024 {

    private val mergeASC = MergeByAscendingMoney()

    @Test
    fun `Happy pass - sort ascending`() {
        assertEquals(
            listOf(
                Money(25.3, CurrencyType.USD),
                Money(45.0, CurrencyType.EUR),
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.ASC,
                listOf(
                    Money(45.0, CurrencyType.EUR),
                    Money(25.3, CurrencyType.USD),
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Happy pass - sort descending`() {
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB),
                Money(45.0, CurrencyType.EUR),
                Money(25.3, CurrencyType.USD)
            ),
            mergeMoney(
                AscendingType.DESC,
                listOf(
                    Money(45.0, CurrencyType.EUR),
                    Money(25.3, CurrencyType.USD),
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Happy pass - return a list when size is less than 2`() {
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.DESC,
                listOf(
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.ASC,
                listOf(
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Happy pass - return a list where all the elements are the same`() {
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.DESC,
                listOf(
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.ASC,
                listOf(
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Happy pass - return a list where several elements are the same`() {
        assertEquals(
            listOf(
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(45.5, CurrencyType.RUB),
                Money(35.5, CurrencyType.RUB),
                Money(25.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.DESC,
                listOf(
                    Money(25.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(35.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(45.5, CurrencyType.RUB)
                )
            )
        )
        assertEquals(
            listOf(
                Money(25.5, CurrencyType.RUB),
                Money(35.5, CurrencyType.RUB),
                Money(45.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB),
                Money(65.5, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.ASC,
                listOf(
                    Money(45.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(25.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB),
                    Money(35.5, CurrencyType.RUB),
                    Money(65.5, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Happy pass - return a list where all the element's amounts are 0`() {
        assertEquals(
            listOf(
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.DESC,
                listOf(
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB)
                )
            )
        )
        assertEquals(
            listOf(
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB),
                Money(0.0, CurrencyType.RUB)
            ),
            mergeMoney(
                AscendingType.ASC,
                listOf(
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB),
                    Money(0.0, CurrencyType.RUB)
                )
            )
        )
    }

    @Test
    fun `Negative pass - return empty list when empty list given`() {
        assertEquals(
            listOf(),
            mergeMoney(
                AscendingType.DESC,
                listOf()
            )
        )
        assertEquals(
            listOf(),
            mergeMoney(
                AscendingType.ASC,
                listOf()
            )
        )
    }

    @Test
    fun `Happy pass - `() {
        val money1 = Money(25.0, CurrencyType.USD)
        val money2 = Money(30.0, CurrencyType.EUR)
       println(money1 + money2)
    }


}