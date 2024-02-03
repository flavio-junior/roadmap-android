package br.com.weather.brazil.data.repository

class WeatherRepositoryImp(
    private val weatherAPI: WeatherAPI
) {
    suspend fun getWeather() = weatherAPI.getWeather()
}