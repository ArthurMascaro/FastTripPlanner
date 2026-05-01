package br.edu.ifsp.scl.sc3044599.fasttripplanner.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TripOptionsScreen(
    destination: String,
    days: Int,
    dailyBudget: Double,
    on_return_click: () -> Unit = {}
) {
}

@Preview(showBackground = true)
@Composable
fun TripOptionsScreenPreview() {
    TripOptionsScreen(
        destination = "Rio de Janeiro",
        days = 5,
        dailyBudget = 100.0
    )
}