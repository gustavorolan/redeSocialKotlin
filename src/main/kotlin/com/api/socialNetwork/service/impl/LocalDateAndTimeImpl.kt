package com.api.socialNetwork.service.impl

import com.api.socialNetwork.service.LocalDateAndTime
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class LocalDateAndTimeImpl : LocalDateAndTime {
    override fun get(): LocalDateTime = LocalDateTime.now()!!
}