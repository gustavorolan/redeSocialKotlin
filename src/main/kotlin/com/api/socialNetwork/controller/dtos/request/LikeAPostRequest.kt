package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class LikeAPostRequest(
    private var idPost: @NotNull Long
)