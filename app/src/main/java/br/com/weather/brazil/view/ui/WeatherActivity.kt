package br.com.weather.brazil.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.weather.brazil.R
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.databinding.ActWeatherBinding
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
                val apiResultHandler = ApiResultHandler<Weather>(this@WeatherActivity,
                    onLoading = { stateProgress(enabled = true) },
                    onSuccess = {
                        stateProgress(enabled = false)
                        it?.let {
                            when (it.results.conditionSlug) {
                                "storm" -> binding.iconConditionSlug.setImageResource(R.drawable.storm)
                                "snow" -> binding.iconConditionSlug.setImageResource(R.drawable.snow)
                                "hail" -> binding.iconConditionSlug.setImageResource(R.drawable.hail)
                                "rain" -> binding.iconConditionSlug.setImageResource(R.drawable.rain)
                                "fog" -> binding.iconConditionSlug.setImageResource(R.drawable.fog)
                                "clear_day" -> binding.iconConditionSlug.setImageResource(R.drawable.clear_day)
                                "clear_night" -> binding.iconConditionSlug.setImageResource(R.drawable.cloudly_night)
                                "cloud" -> binding.iconConditionSlug.setImageResource(R.drawable.cloud)
                                "cloudly_day" -> binding.iconConditionSlug.setImageResource(R.drawable.clear_day)
                                "cloudly_night" -> binding.iconConditionSlug.setImageResource(R.drawable.cloudly_night)
                                "none_day" -> binding.iconConditionSlug.setImageResource(R.drawable.none_day)
                                "none_night" -> binding.iconConditionSlug.setImageResource(R.drawable.none_night)
                            }
                            binding.cityName.text = it.results.cityName
                            binding.temp.text = "${it.results.temp} º"
                            binding.recyclerviewNextDays.adapter =
                                WeatherAdapterItem(it.results.forecast)
                        }
                    },
                    onFailure = {
                        stateProgress(false)
                    })
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