package br.com.weather.brazil.view.viewmodel

import androidx.lifecycle.ViewModel
import br.com.weather.brazil.data.repository.WeatherRepository

class WeatherViewModel(
    private val weather: WeatherRepository
) : ViewModel() {

    fun getWeather() {
        weather.getWeather()
    }
}