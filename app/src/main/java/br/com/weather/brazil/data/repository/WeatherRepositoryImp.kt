package br.com.weather.brazil.data.repository

class WeatherRepositoryImp(
    private val weatherAPI: WeatherAPI
) {
    fun getWeather() = weatherAPI.getWeather()
}