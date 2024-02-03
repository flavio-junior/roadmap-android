package br.com.weather.brazil.network

import retrofit2.Retrofit

private const val BASE_URL_APP = "https://api.hgbrasil.com/"

fun weatherApi(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL_APP)
        .build()
        .create(Retrofit::class.java)
}