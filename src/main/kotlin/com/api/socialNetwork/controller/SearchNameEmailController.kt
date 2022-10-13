package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.SearchNameEmailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchNameEmailController(
    private val searchNameEmailService: SearchNameEmailService
){
    @PostMapping
    fun search(@RequestBody request: SearchNameEmailRequest): ResponseEntity<List<UserAccountResponse>> {
        val userAccountResponse =  searchNameEmailService.search(request)
        return ResponseEntity.ok(userAccountResponse)
    }

}