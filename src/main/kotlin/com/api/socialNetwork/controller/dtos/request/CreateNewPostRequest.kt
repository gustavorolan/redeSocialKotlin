package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateNewPostRequest(
     val postText: @NotEmpty String,
     val privatePost: @NotNull Boolean = false,
     val PostImg: String ?= "",
)
