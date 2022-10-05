package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import javax.validation.Valid

interface AcceptFriendshipService {
    fun accept(request: @Valid AcceptFriendshipRequest)
}