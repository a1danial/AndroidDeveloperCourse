package com.example.androiddevelopercourse

import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.androiddevelopercourse.A1ABC.Unit2.calculateCustomTip

class Unit2_Path3_TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {

    }
}

@Test
fun calculate_20_percent_tip_no_roundup() {
    val amount = 10.00
    val tipPercent = 20.00
    val expectedTip = "$2.00"
    val actualTip = calculateCustomTip(amount, tipPercent, false)
    assertEquals(expectedTip, actualTip)
}