package br.com.templete.components

import kotlinx.coroutines.delay

suspend fun initDelay(time: Long, onEnd: () -> Unit = {}) {
    delay(timeMillis = time)
    onEnd()
}
