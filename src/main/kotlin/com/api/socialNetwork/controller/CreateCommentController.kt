package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest
import com.api.socialNetwork.service.CreateNewCommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post/comment/create")
class CreateCommentController(
    private val createNewCommentService: CreateNewCommentService
) {
    @PostMapping
    fun createComment(@RequestBody request: @Valid CreateNewCommentRequest): ResponseEntity<String> {
        createNewCommentService.post(request)
        return ResponseEntity.ok("You've made a comment")
    }
}