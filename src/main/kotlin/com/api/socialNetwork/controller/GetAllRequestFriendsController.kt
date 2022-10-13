package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.GetAllRequestFriendsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user/getAllRequestFriends")
class GetAllRequestFriendsController(
    private val  getAllRequestFriendsService: GetAllRequestFriendsService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<UserAccountResponse>> {
        val allRequestFriends:List<UserAccountResponse> = getAllRequestFriendsService.get()
        return ResponseEntity.ok(allRequestFriends)
    }
}