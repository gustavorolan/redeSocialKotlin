package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.CommentResponse
import com.api.socialNetwork.service.GetAllCommentsFromPostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post/{id}/comments")
class GetAllCommentsFromPostController(
    private val getAllCommentsFromPostService: GetAllCommentsFromPostService
) {
    @GetMapping
    fun getAll(@PathVariable id: Long): ResponseEntity<List<CommentResponse>> {
        val commentsResponseList = getAllCommentsFromPostService.get(id)
        return ResponseEntity.ok(commentsResponseList)
    }
}