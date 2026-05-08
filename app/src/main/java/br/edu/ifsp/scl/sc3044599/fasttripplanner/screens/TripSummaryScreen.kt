package br.edu.ifsp.scl.sc3044599.fasttripplanner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import br.edu.ifsp.scl.sc3044599.fasttripplanner.utils.CostCalculator

@Composable
fun TripSummaryScreen(
    destination: String,
    days: Int,
    dailyBudget: Double,
    hasFood: Boolean,
    hasTransport: Boolean,
    hasTours: Boolean,
    economicMode: Boolean,
    hostingType: HostingType,
    onReturnClick: () -> Unit = {},
    onFinishClick: () -> Unit = {}
) {
    val maxWidthModifier = Modifier.fillMaxWidth()

    val costCalculator = CostCalculator(
        hostingType = hostingType,
        hasFood = hasFood,
        hasTransport = hasTransport,
        hasTours = hasTours,
        days = days,
        dailyBudget = dailyBudget,
        economicMode = economicMode
    )

    val totalCost = costCalculator.calculateTotalCost()
    val formattedDailyBudget = "R$ %.2f".format(dailyBudget)
    val formattedTotalCost = "R$ %.2f".format(totalCost)

    Column(
        modifier = maxWidthModifier
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = maxWidthModifier
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Trip Summary",
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            HorizontalDivider()
        }

        Column(
            modifier = maxWidthModifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Dados principais",
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            Text(text = "Destino: $destination")
            Text(text = "Dias: $days")
            Text(text = "Orçamento diário: $formattedDailyBudget")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Opções selecionadas",
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            Text(text = "Hospedagem: ${hostingType.getDisplayName()}")
            Text(text = "Alimentação: ${if (hasFood) "Sim" else "Não"}")
            Text(text = "Transporte: ${if (hasTransport) "Sim" else "Não"}")
            Text(text = "Passeios: ${if (hasTours) "Sim" else "Não"}")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Custo total: $formattedTotalCost",
                fontSize = 18.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = onReturnClick
                ) {
                    Text("Voltar")
                }

                Button(
                    onClick = onFinishClick
                ) {
                    Text("Finalizar")
                }
            }
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
        hostingType = HostingType.ECONOMIC,
        economicMode = false
    )
}