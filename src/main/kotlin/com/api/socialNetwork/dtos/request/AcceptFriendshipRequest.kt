package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotNull

data class AcceptFriendshipRequest (
    var friendshipId: @NotNull Long? = null
)