package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateNewPostRequest(
     var postText: @NotEmpty String,
     val privatePost: @NotNull Boolean = false,
     val PostImg: String? = null,
)
