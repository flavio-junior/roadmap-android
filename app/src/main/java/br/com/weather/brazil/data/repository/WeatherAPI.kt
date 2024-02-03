package br.com.weather.brazil.data.repository

import br.com.weather.brazil.data.dto.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherAPI {
    @GET("weather")
    suspend fun getWeather(): Response<Weather>
}
