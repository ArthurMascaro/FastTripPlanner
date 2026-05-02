package br.edu.ifsp.scl.sc3044599.fasttripplanner.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.HostingType
import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.TripIntentKeys
import br.edu.ifsp.scl.sc3044599.fasttripplanner.screens.TripSummaryScreen
import br.edu.ifsp.scl.sc3044599.fasttripplanner.ui.theme.FastTripPlannerTheme

class TripSummaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra(TripIntentKeys.DESTINATION) ?: ""
        val days = intent.getIntExtra(TripIntentKeys.DAYS, 0)
        val dailyBudget = intent.getDoubleExtra(TripIntentKeys.DAILY_BUDGET, 0.0)
        val hostingType = intent.getSerializableExtra(TripIntentKeys.HOSTING_TYPE) as? HostingType
            ?: HostingType.ECONOMIC
        val hasFood = intent.getBooleanExtra(TripIntentKeys.HAS_FOOD, false)
        val hasTransport = intent.getBooleanExtra(TripIntentKeys.HAS_TRANSPORT, false)
        val hasTours = intent.getBooleanExtra(TripIntentKeys.HAS_TOURS, false)

        setContent {
            FastTripPlannerTheme {
                TripSummaryScreen(
                    destination = destination,
                    days = days,
                    dailyBudget = dailyBudget,
                    hasFood = hasFood,
                    hasTransport = hasTransport,
                    hasTours = hasTours,
                    hostingType = hostingType,
                    onReturnClick = {
                        finish()
                    }
                )
            }
        }
    }
}