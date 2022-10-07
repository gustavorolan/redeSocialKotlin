package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import com.api.socialNetwork.service.CreateNewPostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post/create")
class CreateNewPostController(
    private val createNewPostService: CreateNewPostService
) {
    @PostMapping
    fun createPost(@RequestBody request: @Valid CreateNewPostRequest): ResponseEntity<String> {
        createNewPostService.post(request)
        return ResponseEntity.ok("You've created a post")
    }
}