package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.GetFriendsResponseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user/getAllFriends")
class GetFriendsController(
    private  val getFriendsResponseService: GetFriendsResponseService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<UserAccountResponse>> {
        val friendsResponse:List<UserAccountResponse> = getFriendsResponseService.get()
        return ResponseEntity.ok(friendsResponse);
    }
}