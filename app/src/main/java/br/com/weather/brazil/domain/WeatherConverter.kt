package br.com.weather.brazil.domain

import br.com.weather.brazil.data.dto.ForecastRequestDTO
import br.com.weather.brazil.data.dto.ResultsRequestDTO
import br.com.weather.brazil.data.dto.WeatherRequestDTO
import br.com.weather.brazil.view.vo.ForecastResponseVO
import br.com.weather.brazil.view.vo.ResultsResponseVO
import br.com.weather.brazil.view.vo.WeatherResponseVO

class WeatherConverter {

    fun converterWeather(weatherDTO: WeatherRequestDTO): WeatherResponseVO = WeatherResponseVO(
        resultsResponseVO = converterResult(weatherDTO.resultsRequestDTO)
    )

    private fun converterResult(resultsResultDTO: ResultsRequestDTO): ResultsResponseVO =
        ResultsResponseVO(
            cityName = resultsResultDTO.cityName,
            forecastResponseVO = converterForecast(resultsResultDTO.forecastRequestDTO),
            humidity = resultsResultDTO.humidity,
            imgId = resultsResultDTO.imgId,
            latitude = resultsResultDTO.latitude,
            longitude = resultsResultDTO.longitude,
            moonPhase = resultsResultDTO.moonPhase,
            rain = resultsResultDTO.rain,
            sunrise = resultsResultDTO.sunrise,
            sunset = resultsResultDTO.sunset,
            temp = resultsResultDTO.temp,
            time = resultsResultDTO.time,
            timezone = resultsResultDTO.timezone,
            windCardinal = resultsResultDTO.windCardinal,
            windDirection = resultsResultDTO.windDirection,
            windSpeedy = resultsResultDTO.windSpeedy
        )

    private fun converterForecast(forecastResponseDTO: List<ForecastRequestDTO>): List<ForecastResponseVO> =
        forecastResponseDTO.map {
            ForecastResponseVO(
                cloudiness = it.cloudiness,
                condition = it.condition,
                date = it.date,
                description = it.description,
                max = it.max,
                min = it.min,
                rain = it.rain,
                rainProbability = it.rainProbability,
                weekday = it.weekday,
                windSpeedy = it.windSpeedy
            )
        }
}