package br.com.weather.brazil.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.weather.brazil.databinding.ActWeatherBinding

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
