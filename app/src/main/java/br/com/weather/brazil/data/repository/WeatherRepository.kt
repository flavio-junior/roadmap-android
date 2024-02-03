package br.com.weather.brazil.data.repository

import android.content.Context
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.utils.NetWorkResult
import br.com.weather.brazil.utils.toResultFlow
import kotlinx.coroutines.flow.Flow

class WeatherRepository(
    private val weatherRepositoryImp: WeatherRepositoryImp
) {
    suspend fun getWeather(context: Context): Flow<NetWorkResult<Weather>> {
        return toResultFlow(context) {
            weatherRepositoryImp.getWeather()
        }
    }
}