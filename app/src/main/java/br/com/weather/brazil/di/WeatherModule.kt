package br.com.weather.brazil.di

import br.com.weather.brazil.data.repository.WeatherRepository
import br.com.weather.brazil.data.repository.WeatherRepositoryImp
import br.com.weather.brazil.network.weatherApi
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val WeatherModule = module {
    single { weatherApi() }
    single<WeatherRepository> { WeatherRepositoryImp() }
    viewModel { WeatherViewModel(get()) }
}