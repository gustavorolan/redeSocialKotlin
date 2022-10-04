package com.api.socialNetwork.controller

import com.api.socialNetwork.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.service.AcceptFriendshipService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

class AcceptFriendshipController(
    private var acceptFriendshipService: AcceptFriendshipService
    ) {
    @PutMapping
    fun accept(@RequestBody request: @Valid AcceptFriendshipRequest) {
        return acceptFriendshipService.accept(request)
    }
}