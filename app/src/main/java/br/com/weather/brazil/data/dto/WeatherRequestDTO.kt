package br.com.weather.brazil.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherRequestDTO(
    @SerializedName("results")
    val resultsRequestDTO: ResultsRequestDTO
)