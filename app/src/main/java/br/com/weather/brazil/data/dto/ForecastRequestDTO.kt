package br.com.weather.brazil.data.dto

import com.google.gson.annotations.SerializedName

data class ForecastRequestDTO(
    @SerializedName("cloudiness")
    val cloudiness: Double,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("rain")
    val rain: Double,
    @SerializedName("rain_probability")
    val rainProbability: Int,
    @SerializedName("weekday")
    val weekday: String,
    @SerializedName("wind_speedy")
    val windSpeedy: String
)