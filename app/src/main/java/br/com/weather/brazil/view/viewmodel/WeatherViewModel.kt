package br.com.weather.brazil.view.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.data.repository.WeatherRepository
import br.com.weather.brazil.utils.NetWorkResult
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    application: Application
) : BaseViewModel(application) {

    private val _responseWeather: MutableLiveData<NetWorkResult<Weather>> = MutableLiveData()
    val responseWeather: LiveData<NetWorkResult<Weather>> = _responseWeather

    fun getWeather(latitude: Double, longitude: Double) = viewModelScope.launch {
        weatherRepository.getWeather(context, latitude, longitude).collect {
            _responseWeather.value = it
        }
    }
}
