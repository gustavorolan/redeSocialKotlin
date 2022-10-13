package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.service.GetAllFriendsPostResponseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user/getPostFriends")
class GetFriendsPostsController(
    private val getAllFriendsPostResponseService: GetAllFriendsPostResponseService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<PostResponse>> {
        val allFriendsPosts: List<PostResponse> = getAllFriendsPostResponseService.get()
        return ResponseEntity.ok(allFriendsPosts)
    }
}