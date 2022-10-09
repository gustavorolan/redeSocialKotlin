package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest
import com.api.socialNetwork.service.ChangeUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user/changeUser")
class ChangeUserController(
    private val  changeUserService: ChangeUserService
) {
    @PutMapping
    fun change(@RequestBody request: ChangeUserRequest): ResponseEntity<String> {
        changeUserService.change(request)
        return ResponseEntity.ok("You've changed your profile info")
    }

}