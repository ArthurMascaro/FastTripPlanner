package br.edu.ifsp.scl.sc3044599.fasttripplanner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.HostingType

@Composable
fun TripSummaryScreen(
    destination: String,
    days: Int,
    dailyBudget: Double,
    hasFood: Boolean,
    hasTransport: Boolean,
    hasTours: Boolean,
    hostingType: HostingType,
    onReturnClick: () -> Unit = {}
) {
    val maxWidthModifier = Modifier.fillMaxWidth()

    Column(
        modifier = maxWidthModifier
            .fillMaxHeight()
    ) {
        // <-- Header -->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = maxWidthModifier
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            Text(
                text = "Trip Summary",
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripSummaryScreenPreview() {
    TripSummaryScreen(
        destination = "Rio de Janeiro",
        days = 5,
        dailyBudget = 100.0,
        hasFood = false,
        hasTransport = false,
        hasTours = false,
        hostingType = HostingType.ECONOMIC
    )
}