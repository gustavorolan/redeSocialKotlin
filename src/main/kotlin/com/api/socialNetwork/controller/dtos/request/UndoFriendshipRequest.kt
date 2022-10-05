package com.api.socialNetwork.controller.dtos.request

import javax.validation.constraints.NotNull

data class UndoFriendshipRequest(
    private var idToUndoFriendShip: @NotNull Long
)