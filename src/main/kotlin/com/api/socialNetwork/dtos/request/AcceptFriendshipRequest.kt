package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AcceptFriendshipRequest (
    private val postText: @NotEmpty String,
    private val privatePost: @NotNull Boolean = false,
    private val PostImg: String? = ""
)