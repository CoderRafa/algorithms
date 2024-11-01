package com.rafengimprove.practice.model.oop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BirdTest {

    @Test
    fun `Happy pass - say the correct thing`() {
        val hawk: PredatorBirdImpl = HawkImpl()
        assertEquals("I am a hawk", hawk.say())
        assertEquals("I am flying", hawk.walk())
    }

    @Test
    fun `Happy pass - count the adds`() {
        val myCustomList = MyCustomList<Int>(mutableListOf<Int>())

        assertEquals(0, myCustomList.count())

        myCustomList.add(4)
        myCustomList.add(5)

        assertEquals(2, myCustomList.count())
    }
}

