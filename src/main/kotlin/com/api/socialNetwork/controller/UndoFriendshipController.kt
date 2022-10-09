package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.UndoFriendshipRequest
import com.api.socialNetwork.service.UndoFriendshipService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user/undoFriendship")
class UndoFriendshipController (
    private val undoFriendshipService: UndoFriendshipService
        ){

    @PutMapping
    fun undo(@RequestBody request: @Valid UndoFriendshipRequest): ResponseEntity<String> {
        undoFriendshipService.undo(request)
        return ResponseEntity.ok("You've undid this friendship")
    }

}