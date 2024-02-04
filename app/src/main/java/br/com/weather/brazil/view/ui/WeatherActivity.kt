package br.com.weather.brazil.view.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import br.com.weather.brazil.R
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.databinding.ActWeatherBinding
import br.com.weather.brazil.domain.conditionSlugFactory
import br.com.weather.brazil.utils.ApiResultHandler
import br.com.weather.brazil.view.adapter.WeatherAdapterItem
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.android.inject

private const val REQUEST_CODE = 100

class WeatherActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: ActWeatherBinding
    private val viewModel: WeatherViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getLocation()
        observeRequest()
    }
    private fun getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                REQUEST_CODE
            )
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    viewModel.getWeather(it.latitude, it.longitude)
                }
            }
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
