package br.edu.ifsp.scl.sc3044599.fasttripplanner.utils

class TripFormValidator {
    fun validateDestination(destination: String): String? {
        if (destination.isBlank()) {
            return "Destino é obrigatório"
        }

        return null
    }

    fun validateDays(days: Int): String? {
        if (days <= 0) {
            return "Dias devem ser maiores que zero"
        }

        return null
    }

    fun validateDailyBudget(dailyBudget: Double): String? {
        if (dailyBudget <= 0) {
            return "Orçamento diário deve ser maior que zero"
        }

        return null
    }
}