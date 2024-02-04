package br.com.weather.brazil.domain

import br.com.weather.brazil.R

fun conditionSlugFactory(conditionSlug: String): Int {
    return when (conditionSlug) {
        "storm" -> R.drawable.storm
        "snow" -> R.drawable.snow
        "hail" -> R.drawable.hail
        "rain" -> R.drawable.rain
        "fog" -> R.drawable.fog
        "clear_day" -> R.drawable.clear_day
        "clear_night" -> R.drawable.cloudly_night
        "cloud" -> R.drawable.cloud
        "cloudly_day" -> R.drawable.clear_day
        "cloudly_night" -> R.drawable.cloudly_night
        "none_day" -> R.drawable.none_day
        "none_night" -> R.drawable.none_night
        else -> R.drawable.none_day
    }
}
