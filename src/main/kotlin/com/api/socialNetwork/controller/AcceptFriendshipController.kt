package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.service.AcceptFriendshipService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user/acceptNewFriendship")
class AcceptFriendshipController(
    private var acceptFriendshipService: AcceptFriendshipService
    ) {
    @PutMapping
    fun accept(@RequestBody request: @Valid AcceptFriendshipRequest): ResponseEntity<String> {
        acceptFriendshipService.accept(request)
        return ResponseEntity.ok("You accepted the request")
    }
}