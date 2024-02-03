package br.com.weather.brazil.di

import br.com.weather.brazil.data.repository.WeatherRepository
import br.com.weather.brazil.data.repository.WeatherRepositoryImp
import br.com.weather.brazil.domain.WeatherConverter
import br.com.weather.brazil.network.provideConverterFactory
import br.com.weather.brazil.network.provideHttpClient
import br.com.weather.brazil.network.provideRetrofit
import br.com.weather.brazil.network.provideService
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val WeatherModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideService(get()) }
    factory { WeatherRepository(get()) }
    factory { WeatherRepositoryImp(get()) }
    factory { WeatherConverter() }
    viewModel { WeatherViewModel(get(), get(), get()) }
    viewModelOf(::WeatherViewModel)
}