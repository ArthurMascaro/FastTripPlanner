package br.edu.ifsp.scl.sc3044599.fasttripplanner.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.HostingType

@Composable
fun TripOptionsScreen(
    onReturnClick: () -> Unit = {},
    onCalculateClick: (
        hostingType: HostingType,
        hasFood: Boolean,
        hasTransport: Boolean,
        hasTours: Boolean
    ) -> Unit = { _, _, _, _ -> }
) {
    val maxWidthModifier = Modifier.fillMaxWidth()

    var selectedHostingType by rememberSaveable { mutableStateOf(HostingType.ECONOMIC.name) }
    var hasFood by rememberSaveable { mutableStateOf(false) }
    var hasTransport by rememberSaveable { mutableStateOf(false) }
    var hasTours by rememberSaveable { mutableStateOf(false) }

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
                text = "Trip Options",
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            HorizontalDivider()
        }

        // <-- Seleção de tipo de hospedagem -->
        Column(
            modifier = maxWidthModifier
                .padding(top = 10.dp)
        ) {
            Column(
                modifier = maxWidthModifier
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Tipo de hospedagem",
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedHostingType == HostingType.ECONOMIC.name,
                        onClick = {
                            selectedHostingType = HostingType.ECONOMIC.name
                        }
                    )
                    Text("Econômica")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedHostingType == HostingType.COMFORT.name,
                        onClick = {
                            selectedHostingType = HostingType.COMFORT.name
                        }
                    )
                    Text("Conforto")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedHostingType == HostingType.LUXURY.name,
                        onClick = {
                            selectedHostingType = HostingType.LUXURY.name
                        }
                    )
                    Text("Luxo")
                }
            }
        }

        HorizontalDivider()

        // <-- Seleção de serviços adicionais -->
        Column(
            modifier = maxWidthModifier
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Serviços adicionais",
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = hasTransport,
                    onCheckedChange = { checked ->
                        hasTransport = checked
                    }
                )
                Text("Transporte")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = hasFood,
                    onCheckedChange = { checked ->
                        hasFood = checked
                    }
                )
                Text("Alimentação")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = hasTours,
                    onCheckedChange = { checked ->
                        hasTours = checked
                    }
                )
                Text("Passeios")
            }
        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 4.dp)
        ) {
            Button(onClick = onReturnClick) {
                Text(text = "Voltar")
            }

            Button(
                onClick = {
                    val hostingType = HostingType.valueOf(selectedHostingType)
                    onCalculateClick(
                        hostingType,
                        hasFood,
                        hasTransport,
                        hasTours
                    )
                }
            ) {
                Text(text = "Calcular")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripOptionsScreenPreview() {
    TripOptionsScreen()
}