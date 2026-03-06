package com.stewardapostol.simpleList.ui.screen

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.stewardapostol.simpleList.ui.theme.SimpleListTheme
import org.junit.Rule
import org.junit.Test

class SaleScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun saleScreen_displaysCorrectInitialUI() {
        // Start the UI
        composeTestRule.setContent {
            SimpleListTheme {
                SaleScreen()
            }
        }

        // 1. Verify Header exists
        composeTestRule.onNodeWithText("Sale").assertIsDisplayed()

        // 2. Verify Total section exists
        composeTestRule.onNodeWithText("Total").assertIsDisplayed()

        composeTestRule.onAllNodesWithText("$", substring = true).assertCountEquals(1)
    }

    @Test
    fun saleScreen_scrollsToBottom() {
        composeTestRule.setContent {
            SimpleListTheme {
                SaleScreen()
            }
        }

        composeTestRule.onNode(hasScrollAction()).performScrollToIndex(9)
    }
}