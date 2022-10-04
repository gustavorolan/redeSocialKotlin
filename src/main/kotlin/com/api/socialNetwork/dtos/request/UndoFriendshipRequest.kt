package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotNull

data class UndoFriendshipRequest(
    private var idToUndoFriendShip: @NotNull Long
)