package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.LikePostRequest
import com.api.socialNetwork.service.LikePostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post/like")
class LikePostController(
    private val likePostService: LikePostService
) {
    @PostMapping
    fun like(@RequestBody request: @Valid LikePostRequest): ResponseEntity<String> {
        val response = likePostService.like(request)
        return ResponseEntity.ok(response)
    }

}