package br.edu.ifsp.scl.sc3044599.fasttripplanner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FastTripPlannerApp() {
    var destination: String by rememberSaveable() { mutableStateOf("")}
    var destinationError: String? by rememberSaveable() { mutableStateOf(null) }

    var days: Int by rememberSaveable() { mutableIntStateOf(0) }
    var daysError: String? by rememberSaveable() { mutableStateOf(null) }

    var dailyBudget: Double by rememberSaveable() { mutableDoubleStateOf(0.0) }
    var dailyBudgetError: String? by rememberSaveable() { mutableStateOf(null) }

    val maxWidthModifier = Modifier.fillMaxWidth();

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
                text = "Fast Trip Planner",
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            HorizontalDivider()
        }

       Column(
            modifier = maxWidthModifier
                .padding(top = 20.dp)
       ) {
           Column(
               maxWidthModifier
           ) {
               Text(
                   text = "Informe o destino da viagem",
                   fontSize = 16.sp
               )
               TextField(
                   value = destination,
                   onValueChange = { destination = it },
                   isError = destinationError != null,
                   placeholder = { Text(text = "Rio de Janeiro") },
                   maxLines = 2,
                   supportingText = {
                       if(destinationError != null){
                           Text(destinationError!!)
                       }
                   },
                   modifier = Modifier.fillMaxWidth()
               )
           }

           Column(
               maxWidthModifier
           ) {
               Text(
                   text = "Informe a duração da viagem (em dias)",
                   fontSize = 16.sp
               )
               TextField(
                   value = if(days == 0) "" else days.toString(),
                   onValueChange = { days = it.toIntOrNull() ?: 0 },
                   keyboardOptions = KeyboardOptions(
                       keyboardType = KeyboardType.Number
                   ),
                   isError = daysError != null,
                   placeholder = { Text(text = "5") },
                   maxLines = 1,
                   supportingText = {
                       if(daysError != null){
                           Text(daysError!!)
                       }
                   },
                   modifier = Modifier.fillMaxWidth()
               )
           }

           Column(
               maxWidthModifier
           ) {
               Text(
                   text = "Informe o orçamento diário (em R$)",
                   fontSize = 16.sp
               )
               TextField(
                   value = if(dailyBudget == 0.0) "" else dailyBudget.toString(),
                   onValueChange = { dailyBudget = it.toDoubleOrNull() ?: 0.0 },
                   keyboardOptions = KeyboardOptions(
                       keyboardType = KeyboardType.Number
                   ),
                   isError = dailyBudgetError != null,
                   placeholder = { Text(text = "100.00") },
                   maxLines = 1,
                   supportingText = {
                       if(dailyBudgetError != null){
                           Text(dailyBudgetError!!)
                       }
                   },
                   modifier = Modifier.fillMaxWidth()
               )
           }

           Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
           ) {
               Button(
                   onClick = {
                       destination = ""
                       destinationError = null
                       days = 0
                       daysError = null
                       dailyBudget = 0.0
                       dailyBudgetError = null
                   }
               ) {
                   Text("Limpar")
               }
           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun FastTripPlannerAppPreview() {
    FastTripPlannerApp()
}