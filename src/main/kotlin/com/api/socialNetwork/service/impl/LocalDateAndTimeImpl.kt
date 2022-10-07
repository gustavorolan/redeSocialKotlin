package com.api.socialNetwork.service.impl

import com.api.socialNetwork.service.LocalDateAndTime
import java.time.LocalDateTime

class LocalDateAndTimeImpl : LocalDateAndTime {
    override fun get(): LocalDateTime = LocalDateTime.now()!!
}