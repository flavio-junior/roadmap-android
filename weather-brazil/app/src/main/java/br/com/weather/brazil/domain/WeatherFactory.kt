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
        "clear_night" -> R.drawable.clear_night
        "cloud" -> R.drawable.cloud
        "cloudly_day" -> R.drawable.cloudly_day
        "cloudly_night" -> R.drawable.cloudly_night
        "none_day" -> R.drawable.none_day
        "none_night" -> R.drawable.none_night
        else -> R.drawable.none_day
    }
}

fun moonPhaseImage(moonPhase: String): Int {
    return when (moonPhase) {
        "new" -> R.drawable.new_moon
        "waxing_crescent" -> R.drawable.waxing_crescent
        "first_quarter" -> R.drawable.first_quarter
        "waxing_gibbous" -> R.drawable.waxing_gibbous
        "full" -> R.drawable.full
        "waning_gibbous" -> R.drawable.waning_gibbous
        "last_quarter" -> R.drawable.last_quarter
        "waning_crescent" -> R.drawable.waning_crescent
        else -> R.drawable.close
    }
}

fun moonPhaseFactory(moonPhase: String): Int {
    return when (moonPhase) {
        "new" -> R.string.new_moon
        "waxing_crescent" -> R.string.waxing_crescent
        "first_quarter" -> R.string.first_quarter
        "waxing_gibbous" -> R.string.waxing_gibbous
        "full" -> R.string.full
        "waning_gibbous" -> R.string.waning_gibbous
        "last_quarter" -> R.string.last_quarter
        "waning_crescent" -> R.string.waning_crescent
        else -> R.string.nullable
    }
}
