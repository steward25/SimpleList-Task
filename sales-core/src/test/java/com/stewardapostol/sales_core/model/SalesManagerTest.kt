package com.stewardapostol.sales_core.model

import org.junit.Assert.assertEquals
import org.junit.Test

class SalesManagerTest {

    @Test
    fun `calculateTotal returns accurate sum of item prices`() {

        // Arrange: Create a fixed list of items to test the math logic
        val testItems = listOf(
            SaleItem("Item A", 10.0),
            SaleItem("Item B", 25.50),
            SaleItem("Item C", 4.50)
        )
        val expectedTotal = 40.0

        // Act: Run the calculation
        val actualTotal = SalesManager.calculateTotal(testItems)

        assertEquals(expectedTotal, actualTotal, 0.001)
    }

    @Test
    fun `getMockData returns exactly 10 items`() {
        val items = SalesManager.getMockData()
        assertEquals("The mock list should contain exactly 10 items", 10, items.size)
    }

    @Test
    fun `calculateTotal with empty list returns zero`() {
        assertEquals(0.0, SalesManager.calculateTotal(emptyList()), 0.0)
    }
}