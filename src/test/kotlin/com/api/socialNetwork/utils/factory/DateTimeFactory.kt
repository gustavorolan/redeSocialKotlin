package com.api.socialNetwork.utils.factory

import java.time.LocalDateTime

class DateTimeFactory {
    companion object {
        fun getDateTime(): LocalDateTime =
            LocalDateTime.of(2020, 10, 15, 20, 20)
    }
}