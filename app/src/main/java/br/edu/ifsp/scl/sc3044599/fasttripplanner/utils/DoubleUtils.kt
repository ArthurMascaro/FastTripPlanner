package br.edu.ifsp.scl.sc3044599.fasttripplanner.utils

class DoubleUtils {
    fun normalizeDouble(value: String): Double {
        return value.replace(",", ".").toDouble();
    }
}