package com.api.socialNetwork.service.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class LocalDateAndTimeImplTest {

    private val localDateAndTimeImpl = LocalDateAndTimeImpl()

    @Test
    fun get() {
        Assertions.assertEquals(
            LocalDateTime.now().toLocalDate(),
            localDateAndTimeImpl.get().toLocalDate())
    }
}