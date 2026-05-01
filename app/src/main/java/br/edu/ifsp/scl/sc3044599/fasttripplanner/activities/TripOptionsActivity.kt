package br.edu.ifsp.scl.sc3044599.fasttripplanner.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.TripIntentKeys
import br.edu.ifsp.scl.sc3044599.fasttripplanner.screens.TripOptionsScreen
import br.edu.ifsp.scl.sc3044599.fasttripplanner.ui.theme.FastTripPlannerTheme

class TripOptionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra(TripIntentKeys.DESTINATION) ?: ""
        val days = intent.getIntExtra(TripIntentKeys.DAYS, 0)
        val dailyBudget = intent.getDoubleExtra(TripIntentKeys.DAILY_BUDGET, 0.0)

        setContent {
            FastTripPlannerTheme {
                TripOptionsScreen(
                    destination = destination,
                    days = days,
                    dailyBudget = dailyBudget,
                    on_return_click = {
                        finish()
                    }
                )
            }
        }
    }
}