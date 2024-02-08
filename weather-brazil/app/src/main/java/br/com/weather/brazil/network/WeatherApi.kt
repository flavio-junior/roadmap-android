package br.com.weather.brazil.network

import br.com.weather.brazil.data.repository.WeatherAPI
import br.com.weather.brazil.utils.Constants
import br.com.weather.brazil.utils.Constants.TIME_SECONDS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(TIME_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIME_SECONDS, TimeUnit.SECONDS)
        .build()
}

fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_APP)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideService(retrofit: Retrofit): WeatherAPI = retrofit.create(WeatherAPI::class.java)
