package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest

interface AcceptFriendshipService {
    fun accept(request: AcceptFriendshipRequest)
}