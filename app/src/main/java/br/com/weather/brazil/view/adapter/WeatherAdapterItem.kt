package br.com.weather.brazil.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.weather.brazil.data.dto.Forecast
import br.com.weather.brazil.databinding.ItemWeatherBinding

class WeatherAdapterItem(
   private val forecasts: List<Forecast> = mutableListOf()
) : RecyclerView.Adapter<ForecastsItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastsItemHolder {
        val item = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ForecastsItemHolder(item)
    }

    override fun onBindViewHolder(holder: ForecastsItemHolder, position: Int) {
        val forecast: Forecast = forecasts[position]
        holder.bind(forecast)
    }

    override fun getItemCount(): Int = forecasts.size
}

class ForecastsItemHolder(private val item: ItemWeatherBinding) :
    RecyclerView.ViewHolder(item.root) {
    fun bind(forecast: Forecast) {
        item.name.text = forecast.date
    }
}