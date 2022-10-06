package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.GetUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class GetUserController(
    private val getUserService: GetUserService
) {

    @GetMapping
    fun get(): ResponseEntity<UserAccountResponse> {
        val userAccountResponse:UserAccountResponse = getUserService.get()
        return ResponseEntity.ok(userAccountResponse)
    }
}