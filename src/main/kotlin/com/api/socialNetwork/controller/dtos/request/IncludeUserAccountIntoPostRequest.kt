package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class IncludeUserAccountIntoPostRequest(
    private var idPost: @NotNull Long
)
