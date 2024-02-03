package br.com.weather.brazil.data.dto

import com.google.gson.annotations.SerializedName

data class ResultsRequestDTO(
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("forecast")
    val forecastRequestDTO: List<ForecastRequestDTO>,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("img_id")
    val imgId: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("moon_phase")
    val moonPhase: String,
    @SerializedName("rain")
    val rain: Double,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Int,
    @SerializedName("time")
    val time: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("wind_cardinal")
    val windCardinal: String,
    @SerializedName("wind_direction")
    val windDirection: Int,
    @SerializedName("wind_speedy")
    val windSpeedy: String
)