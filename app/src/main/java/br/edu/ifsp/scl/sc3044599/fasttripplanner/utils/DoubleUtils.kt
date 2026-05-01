package br.edu.ifsp.scl.sc3044599.fasttripplanner.utils

object DoubleUtils {
    fun normalizeDouble(value: String): Double {
        return value
            .replace(",", ".")
            .toDoubleOrNull() ?: 0.0
    }
}