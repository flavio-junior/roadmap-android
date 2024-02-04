package br.com.weather.brazil.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.weather.brazil.R
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.databinding.ActWeatherBinding
import br.com.weather.brazil.domain.conditionSlugFactory
import br.com.weather.brazil.utils.ApiResultHandler
import br.com.weather.brazil.view.adapter.WeatherAdapterItem
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
            viewModel.responseWeather.observe(this) { response ->
                val apiResultHandler = ApiResultHandler<Weather>(
                    this@WeatherActivity,
                    onLoading = { stateProgress(enabled = true) },
                    onSuccess = {
                        stateProgress(enabled = false)
                        it?.let {
                            binding.iconConditionSlug
                                .setImageResource(conditionSlugFactory(it.results.conditionSlug))
                            binding.cityName.text = it.results.cityName
                            binding.temp.text = getString(R.string.temp, it.results.temp)
                            binding.recyclerviewNextDays.adapter =
                                WeatherAdapterItem(it.results.forecast)
                        }
                    },
                    onFailure = {
                        stateProgress(false)
                    }
                )
                apiResultHandler.handleApiResult(response)
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun stateProgress(enabled: Boolean) {
        binding.loadingRequest.isIndeterminate = enabled
        binding.loadingText.isVisible = enabled
    }
}
