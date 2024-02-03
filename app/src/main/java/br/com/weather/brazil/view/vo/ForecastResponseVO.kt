package br.com.weather.brazil.view.vo

data class ForecastResponseVO(
    val cloudiness: Double,
    val condition: String,
    val date: String,
    val description: String,
    val max: Int,
    val min: Int,
    val rain: Double,
    val rainProbability: Int,
    val weekday: String,
    val windSpeedy: String
)