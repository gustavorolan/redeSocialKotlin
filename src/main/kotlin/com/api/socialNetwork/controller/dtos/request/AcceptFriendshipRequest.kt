package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class AcceptFriendshipRequest (
    val friendId: @NotNull Long
)