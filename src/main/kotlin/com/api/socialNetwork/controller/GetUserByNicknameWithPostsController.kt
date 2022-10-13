package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.service.GetUserWithPostsByNicknameService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class GetUserByNicknameWithPostsController(
    private val getUserWithPostsByNickname: GetUserWithPostsByNicknameService
) {
    @GetMapping("/{nickname}")
    fun getByNickName(@PathVariable nickname: String): ResponseEntity<UserWithPostsResponse> {
        val userAccountResponse: UserWithPostsResponse = getUserWithPostsByNickname.get(nickname)
        return ResponseEntity.ok(userAccountResponse)
    }

}