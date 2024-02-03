package br.com.weather.brazil.view.vo

data class ResultsResponseVO(
    val cityName: String,
    val forecastResponseVO: List<ForecastResponseVO>,
    val humidity: Int,
    val imgId: String,
    val latitude: Double,
    val longitude: Double,
    val moonPhase: String,
    val rain: Double,
    val sunrise: String,
    val sunset: String,
    val temp: Int,
    val time: String,
    val timezone: String,
    val windCardinal: String,
    val windDirection: Int,
    val windSpeedy: String
)