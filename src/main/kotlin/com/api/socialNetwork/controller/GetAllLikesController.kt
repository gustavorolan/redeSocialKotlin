package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.service.GetAllLikesFromAPostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post/{id}/likes")
class GetAllLikesController(
    private val  getAllLikesFromAPostService: GetAllLikesFromAPostService
) {
    @GetMapping
    fun getAll(@PathVariable id: Long): ResponseEntity<List<UserWithPostsResponse>> {
        val get:List<UserWithPostsResponse> = getAllLikesFromAPostService.get(id)
        return ResponseEntity.ok(get)
    }
}