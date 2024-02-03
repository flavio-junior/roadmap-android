package br.com.weather.brazil.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.weather.brazil.R
import br.com.weather.brazil.databinding.ActWeatherBinding
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import org.koin.android.ext.android.inject

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActWeatherBinding

    private val viewModel: WeatherViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getWeather()
        binding.mainText.text = getText(R.string.app_name)
    }
}