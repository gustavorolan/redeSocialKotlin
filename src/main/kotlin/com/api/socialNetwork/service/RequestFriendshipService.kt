package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest

interface RequestFriendshipService {
    fun request(request: RequestFriendshipRequest)
}
