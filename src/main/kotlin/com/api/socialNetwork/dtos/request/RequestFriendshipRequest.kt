package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotNull

data class RequestFriendshipRequest(
    private var friendId: @NotNull Long
)
