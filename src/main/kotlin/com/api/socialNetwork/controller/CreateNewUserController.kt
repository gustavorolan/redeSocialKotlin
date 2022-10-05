package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.service.CreateNewUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/createNewUser")
class CreateNewUserController(
    private val createNewUserService: CreateNewUserService
    ) {
    @PostMapping
    fun create(@RequestBody request: @Valid CreateNewUserRequest): ResponseEntity<String> {
        val username = createNewUserService.create(request)
        return ResponseEntity.ok("You created an account with username: $username")
    }
}
