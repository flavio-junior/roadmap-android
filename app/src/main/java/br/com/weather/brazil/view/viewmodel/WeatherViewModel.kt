package br.com.weather.brazil.view.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.weather.brazil.data.dto.WeatherRequestDTO
import br.com.weather.brazil.data.repository.WeatherRepository
import br.com.weather.brazil.domain.WeatherConverter
import br.com.weather.brazil.utils.NetWorkResult
import kotlinx.coroutines.launch

class WeatherViewModel(
    application: Application,
    private val weatherRepository: WeatherRepository,
    private val weatherConverter: WeatherConverter
): BaseViewModel(application) {

    private val _responseWeatherRequestDTO: MutableLiveData<NetWorkResult<WeatherRequestDTO>> = MutableLiveData()
    val responseWeatherRequestDTO: LiveData<NetWorkResult<WeatherRequestDTO>> = _responseWeatherRequestDTO

    fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeather(context).let {
            weatherConverter.converterWeather(it)
        }
    }
}