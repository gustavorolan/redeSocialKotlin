package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.service.GetUserByNicknameService
import com.api.socialNetwork.service.GetUserWithPostsByNicknameService
import com.api.socialNetwork.service.SearchNameEmailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/search")
class SearchController(
    private val getUserByNicknameService: GetUserByNicknameService,
    private val getUserWithPostsByNickname: GetUserWithPostsByNicknameService,
    private val searchNameEmailService: SearchNameEmailService
) {
    @GetMapping("/{nickname}/user")
    fun getByNickName(@PathVariable nickname: String): ResponseEntity<UserAccountResponse> {
        val userAccountResponse: UserAccountResponse = getUserByNicknameService.get(nickname)
        return ResponseEntity.ok(userAccountResponse)
    }

    @GetMapping("/{nickname}/posts")
    fun getByNickNameWithPosts(@PathVariable nickname: String): ResponseEntity<UserWithPostsResponse> {
        val userAccountResponse: UserWithPostsResponse = getUserWithPostsByNickname.get(nickname)
        return ResponseEntity.ok(userAccountResponse)
    }

    @GetMapping("/NameOrEmail/user")
    fun search(@RequestBody request: SearchNameEmailRequest): ResponseEntity<List<UserAccountResponse>> {
        val userAccountResponse =  searchNameEmailService.search(request)
        return ResponseEntity.ok(userAccountResponse)
    }
}