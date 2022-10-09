package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.service.RequestFriendshipService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user/requestNewFriendship")
class RequestFriendshipController (
    private var requestFriendshipService: RequestFriendshipService
        ) {
    @PostMapping
    fun requestFriendship(@RequestBody request: @Valid RequestFriendshipRequest): ResponseEntity<String> {

        requestFriendshipService.request(request)
        return ResponseEntity.ok("You invited as friend")
    }
}