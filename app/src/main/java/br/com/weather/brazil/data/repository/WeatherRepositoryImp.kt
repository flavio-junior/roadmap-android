package br.com.weather.brazil.data.repository

import br.com.weather.brazil.data.dto.Weather
import retrofit2.Call

class WeatherRepositoryImp : WeatherRepository {

    private lateinit var weatherRepository: WeatherRepository

    override fun getWeather(): Call<Weather> {
        return weatherRepository.getWeather()
    }
}