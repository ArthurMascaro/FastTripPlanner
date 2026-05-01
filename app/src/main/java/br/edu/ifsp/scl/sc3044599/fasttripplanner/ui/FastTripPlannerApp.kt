package br.edu.ifsp.scl.sc3044599.fasttripplanner.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FastTripPlannerApp() {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Text(text = "oi")
    }
}

@Preview(showBackground = true)
@Composable
fun FastTripPlannerAppPreview() {
    FastTripPlannerApp()
}