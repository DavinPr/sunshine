package com.adityadavin.sample

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `check last index when list is 0`() {
        val list = listOf<Int>()
        assertEquals(-1, list.lastIndex)
    }
}