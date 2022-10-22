package com.api.socialNetwork.controller.dtos.request

import org.jetbrains.annotations.NotNull

data class SearchNameEmailRequest(
    val search: String ?= "",
    @NotNull val page:Int
)
