package br.com.weather.brazil.view.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.weather.brazil.R
import br.com.weather.brazil.data.dto.Weather
import br.com.weather.brazil.databinding.FragmentWeatherBinding
import br.com.weather.brazil.domain.conditionSlugFactory
import br.com.weather.brazil.domain.moonPhaseFactory
import br.com.weather.brazil.domain.moonPhaseImage
import br.com.weather.brazil.utils.ApiResultHandler
import br.com.weather.brazil.view.adapter.WeatherAdapterItem
import br.com.weather.brazil.view.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.android.inject

private const val REQUEST_CODE = 100

class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val viewModel: WeatherViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)
        getLocation()
        observeRequest()
        listenerLanguage()
    }

    private fun getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
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
            viewModel.responseWeather.observe(requireActivity()) { response ->
                val apiResultHandler = ApiResultHandler<Weather>(
                    requireContext(),
                    onLoading = { stateProgress(enabled = true) },
                    onSuccess = {
                        stateProgress(enabled = false)
                        it?.let {
                            binding.iconConditionSlug
                                .setImageResource(conditionSlugFactory(it.results.conditionSlug))
                            binding.textCityName.text = it.results.city
                            binding.textTemp.text = getString(R.string.temp, it.results.temp)
                            binding.textDescription.text = getString(
                                R.string.currently,
                                it.results.description,
                                it.results.currently
                            )
                            binding.imageMoon.setImageResource(moonPhaseImage(it.results.moonPhase))
                            binding.textMoonPhase.text =
                                getString(moonPhaseFactory(it.results.moonPhase))
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

    private fun listenerLanguage() {
        binding.boxLanguage.setOnClickListener {
            findNavController().navigate(R.id.action_to_navigation_bottom_sheet_language)
        }
    }

    private fun stateProgress(enabled: Boolean) {
        binding.loadingRequest.isIndeterminate = enabled
        binding.textLoading.isVisible = enabled
    }
}
