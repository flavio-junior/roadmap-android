package br.com.weather.brazil.data.repository

class WeatherRepositoryImp(
    private val weatherAPI: WeatherAPI
) {
    suspend fun getWeather(latitude: Double, longitude: Double) =
        weatherAPI.getWeather(latitude = latitude, longitude = longitude)
}
