package com.example.androiddevelopercourse

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.CupcakeScreen
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.data.DataSource
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.data.OrderUiState
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.ui.OrderSummaryScreen
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.ui.SelectOptionScreen
import com.example.androiddevelopercourse.A1ABC.Unit4_Path2.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class Unit4_Path2_CupcakeOrderScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderUiState = OrderUiState(
        quantity = 69,
        flavor = "Mint",
        date = "Wed Nov 2",
        price = "$69",
        pickupOptions = listOf()

    )

    /**
     * When quantity options are provided to StartOrderScreen, the options are displayed on the
     * screen.
     */
    @Test
    fun startOrderScreen_verifyContent() {

        // Load StartOrderScreen screen
        composeTestRule.setContent{
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions,
                onNextButtonClicked = {}
            )
        }

        // Ensure all options are displayed on screen
        DataSource.quantityOptions.forEach { pair ->
            composeTestRule.onNodeWithStringId(pair.first).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(pair.first).assertIsEnabled()
        }
    }

    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        // Then all the options are displayed on the screen.
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        // And then the subtotal is displayed correctly.
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        // And then the next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    @Test
    fun selectOptionScreen_optionFlavor_verifyNextButtonEnabled() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")

        composeTestRule.setContent {
            SelectOptionScreen(
                subtotal = "1.23",
                options = flavors
            )
        }

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
        composeTestRule.onNodeWithText("Cookie").performClick()
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    @Test
    fun selectOptionScreen_optionPickup_verifyNextButtonEnabled() {
        val dateList = listOf("Day 1","Day 2","Day 3")

        composeTestRule.setContent {
            SelectOptionScreen(
                subtotal = "1.23",
                options = dateList
            )
        }

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
        composeTestRule.onNodeWithText("Day 1").performClick()
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    @Test
    fun summaryScreen_verifyContent() {
        val uiState = OrderUiState(
            quantity = 3,
            flavor = "Hazel",
            date = "Day 3",
            price = "1.23"
        )
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = uiState,
                onCancelButtonClicked = {},
                onSendButtonClicked = { _, _ -> }
            )
        }

        // Test
        composeTestRule.onNodeWithText("3 cupcakes").assertIsDisplayed()
        composeTestRule.onNodeWithText("Hazel").assertIsDisplayed()
        composeTestRule.onNodeWithText("Day 3").assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                uiState.price
            )
        ).assertIsDisplayed()
    }
}