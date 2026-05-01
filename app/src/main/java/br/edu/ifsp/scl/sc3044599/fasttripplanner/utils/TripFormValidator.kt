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

    fun validateDailyBudget(dailyBudget: String): String? {
        if(dailyBudget.isBlank()) {
            return "Orçamento diário é obrigatório"
        }

        // permitir ponto ou virgula
        if(!dailyBudget.matches(Regex("^\\d+(\\.\\d{1,2}|,\\d{1,2})?$"))) {
            return "Orçamento diário deve ser um número válido"
        }

        if(DoubleUtils().normalizeDouble(dailyBudget) <= 0) {
            return "Orçamento diário deve ser maior que zero"
        }

        return null
    }
}