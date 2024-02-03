package br.com.weather.brazil

import android.app.Application
import br.com.weather.brazil.di.WeatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationMain : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationMain)
            modules(WeatherModule)
        }
    }
}
