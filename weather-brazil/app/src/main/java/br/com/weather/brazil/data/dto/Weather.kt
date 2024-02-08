package br.com.weather.brazil.data.dto

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("results")
    val results: Results
)
