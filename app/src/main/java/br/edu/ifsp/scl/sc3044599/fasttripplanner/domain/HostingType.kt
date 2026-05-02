package br.edu.ifsp.scl.sc3044599.fasttripplanner.domain

enum class HostingType {
    ECONOMIC,
    COMFORT,
    LUXURY;

    fun getDisplayName(): String {
        return when(this) {
            ECONOMIC -> "Econômico"
            COMFORT -> "Conforto"
            LUXURY -> "Luxo"
        }
    }
}