package com.example.androiddevelopercourse

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.androiddevelopercourse.A1ABC.Unit2.CustomTipScreen
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme
import org.junit.Rule
import org.junit.Test

class Unit2_Path3_TipUITests {

    @get:Rule
//    val composeTestRule = createComposeRule()
    /* Use createAndroidComposeRule<YourActivity>() if you need access to
    an activity */
    val composeTestRule = createAndroidComposeRule<MainActivity>() // Still unsure why this works but not the above

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            AndroidDeveloperCourseTheme {
                CustomTipScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        composeTestRule.onNodeWithText("Tip amount: $2.00").assertExists() // As per course

    }
}

