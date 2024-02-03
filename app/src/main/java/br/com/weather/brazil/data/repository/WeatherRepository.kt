package br.com.weather.brazil.data.repository

import br.com.weather.brazil.data.dto.Weather
import retrofit2.Call
import retrofit2.http.GET

interface WeatherRepository {

    @GET("weather")
    fun getWeather(): Call<Weather>

}