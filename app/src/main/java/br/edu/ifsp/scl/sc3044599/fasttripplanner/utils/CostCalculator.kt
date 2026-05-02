package br.edu.ifsp.scl.sc3044599.fasttripplanner.utils

import br.edu.ifsp.scl.sc3044599.fasttripplanner.domain.HostingType

class CostCalculator(
    val hostingType: HostingType,
    val hasFood: Boolean,
    val hasTransport: Boolean,
    val hasTours: Boolean,
    val days: Int,
    val dailyBudget: Double,
    val baseCost: Double = days * dailyBudget
) {

    fun calculateTotalCost(): Double {
        return (baseCost * hostingMultiplier()) + foodTotal() + transportTotal() + toursTotal()
    }

    private fun hostingMultiplier(): Double {
        return when(hostingType){
            HostingType.ECONOMIC -> 1.0
            HostingType.COMFORT -> 1.5
            HostingType.LUXURY -> 2.2
        }
    }

    private fun toursTotal(): Double {
        if(hasTours){
            return 120.00 * days
        }
        return 0.0
    }

    private fun foodTotal(): Double {
        if(hasFood){
            return 50.00 * days
        }
        return 0.0
    }

    private fun transportTotal(): Double{
        if(hasTransport){
            return 300.00
        }
        return 0.0
    }
}