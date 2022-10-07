package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class LikePostRequest(
     val idPost: @NotNull Long
)