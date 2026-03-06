package com.stewardapostol.simpleList.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stewardapostol.sales_core.model.SalesManager

@Composable
fun SaleScreen() {

    // Generate data once
    val items = remember { SalesManager.getMockData() }
    val total = SalesManager.calculateTotal(items)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Sale",
            color = Color.Blue,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .testTag("screen_title")
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items) { item ->
                SaleRow(label = item.name, price = item.price)
            }
        }

        Divider()

        // Total Row with a specific test tag for the price value
        SaleRow(
            label = "Total",
            price = total,
            isBold = true,
            priceTag = "total_price_display"
        )
    }
}

@Composable
fun SaleRow(
    label: String,
    price: Double,
    isBold: Boolean = false,
    priceTag: String? = null
) {
    val weight = if (isBold) FontWeight.Bold else FontWeight.Normal

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            fontWeight = weight,
            modifier = Modifier.weight(1f)
        )
        
        Row(
            modifier = Modifier.width(80.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "$",
                fontWeight = weight,
                modifier = Modifier.width (16.dp)
            )
            Text(
                text = "%.2f".format(price),
                fontWeight = weight,
                modifier = if (priceTag != null) Modifier.testTag(priceTag) else Modifier
            )
        }
    }
}

@Preview(showBackground = true, name = "Sale Screen Preview")
@Composable
fun SaleScreenPreview() {
    MaterialTheme {
        Surface {
            SaleScreen()
        }
    }
}