package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.UndoFriendshipRequest

interface UndoFriendshipService {
    fun undo(request: UndoFriendshipRequest)
}
