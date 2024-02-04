package br.com.weather.brazil.data.repository

import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.utils.Constants.ACCESS_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather")
    suspend fun getWeather(
        @Query("key") key: String = ACCESS_KEY,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): Response<Weather>
}
