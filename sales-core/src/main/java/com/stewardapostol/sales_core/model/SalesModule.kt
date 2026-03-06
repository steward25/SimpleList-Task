package com.stewardapostol.sales_core.model

import kotlin.random.Random


/**
 * Represents a single product entry in a sale transaction.
 *
 * This data class is compatible with both Kotlin and Java. In Java, it provides
 * standard getter methods (e.g., `getName()` and `getPrice()`) automatically.
 *
 * @property name The display name of the product (e.g., "Toothpaste").
 * @property price The cost of the item in decimal format.
 */
data class SaleItem(val name: String, val price: Double)

/**
 * Manages the generation and calculation of sale items.
 * * This object serves as the single source of truth for mock data and
 * business logic calculations related to sales.
 */
object SalesManager {

    /**
     * A static list of product names used to generate mock sale data.
     */
    private val NAMES = listOf(
        "Toothpaste", "Toothbrush", "Mouthwash", "Hand Soap",
        "Candies", "Cotton", "Body Wash", "Floss",
        "Electric Toothbrush", "Cologne"
    )

    /**
     * Generates a list of [SaleItem] objects based on the predefined [NAMES].
     * Each item is assigned a random price between 5.0 and 50.0.
     *
     * @return A list containing exactly 10 [SaleItem] instances with randomized prices.
     */
    fun getMockData(): List<SaleItem> {
        return NAMES.map { SaleItem(it, Random.nextDouble(5.0, 50.0)) }
    }

    /**
     * Calculates the cumulative total price of a given list of sale items.
     * * This method is annotated with [JvmStatic] to allow seamless
     * static method access when called from Java code.
     *
     * @param items The list of [SaleItem]s to be summed.
     * @return The sum of all item prices as a [Double].
     */
    @JvmStatic
    fun calculateTotal(items: List<SaleItem>) = items.sumOf { it.price }
}
