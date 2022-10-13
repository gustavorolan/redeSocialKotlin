package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.GetUserByNicknameService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("friends")
class GetUserByNicknameController(
    private val getUserByNicknameService: GetUserByNicknameService
) {
    @GetMapping("/{nickname}")
    fun getByNickName(@PathVariable nickname: String): ResponseEntity<UserAccountResponse> {
        val userAccountResponse: UserAccountResponse = getUserByNicknameService.get(nickname)
        return ResponseEntity.ok(userAccountResponse)
    }

}