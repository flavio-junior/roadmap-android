package br.com.weather.brazil.data.dto

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("cid")
    val cid: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("cloudiness")
    val cloudiness: Double,
    @SerializedName("condition_code")
    val conditionCode: String,
    @SerializedName("condition_slug")
    val conditionSlug: String,
    @SerializedName("cref")
    val cref: String,
    @SerializedName("currently")
    val currently: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("forecast")
    val forecast: List<Forecast>,
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