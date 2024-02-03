package br.com.weather.brazil.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.weather.brazil.data.dto.WeatherRequestDTO
import br.com.weather.brazil.databinding.ActWeatherBinding
import br.com.weather.brazil.utils.ApiResultHandler
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import org.koin.android.ext.android.inject

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActWeatherBinding
    private val viewModel: WeatherViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWeather()
        observeRequest()
    }

    private fun getWeather() {
        viewModel.getWeather()
    }

    private fun observeRequest() {
        try {
            viewModel.responseWeatherRequestDTO.observe(this) { response ->
                val apiResultHandler = ApiResultHandler<WeatherRequestDTO>(this@WeatherActivity,
                    onLoading = {
                        showProgress(true)
                    },
                    onSuccess = {
                        showProgress(false)
                        it?.let {
                            binding.mainText.text = it.resultsRequestDTO.cityName
                            binding.main0.text = it.resultsRequestDTO.time
                            binding.main1.text = it.resultsRequestDTO.timezone
                            binding.main2.text = it.resultsRequestDTO.imgId
                        }
                    },
                    onFailure = {
                        binding.mainText.text = "Erro de conexão"
                    })
                apiResultHandler.handleApiResult(response)
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun showProgress(enabled: Boolean = false) {
        if (enabled) {

        } else {
            binding.mainText.text = "Carregando"
        }
    }
}