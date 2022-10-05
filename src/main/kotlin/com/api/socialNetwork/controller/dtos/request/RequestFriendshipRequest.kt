package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class RequestFriendshipRequest(
    private var friendId: @NotNull Long
)
