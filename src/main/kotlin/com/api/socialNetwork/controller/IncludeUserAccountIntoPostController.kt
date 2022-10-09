package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.IncludeUserAccountIntoPostRequest
import com.api.socialNetwork.service.IncludeUserAccountIntoPostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post/includeNewUser")
class IncludeUserAccountIntoPostController(
    private val includeUserAccountIntoPostService: IncludeUserAccountIntoPostService
) {

    @PutMapping
    fun include(@RequestBody request: IncludeUserAccountIntoPostRequest): ResponseEntity<String> {
        includeUserAccountIntoPostService.includeUserAccount(request)
        return ResponseEntity.ok("You've included a user in this post")
    }

}