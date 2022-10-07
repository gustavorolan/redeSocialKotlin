package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class RequestFriendshipRequest(
    var friendId: @NotNull Long
)
