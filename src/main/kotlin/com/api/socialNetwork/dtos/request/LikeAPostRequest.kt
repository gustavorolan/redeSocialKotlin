package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotNull

data class LikeAPostRequest(
    private var idPost: @NotNull Long
)