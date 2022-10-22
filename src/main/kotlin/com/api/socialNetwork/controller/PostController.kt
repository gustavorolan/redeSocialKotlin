package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest
import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import com.api.socialNetwork.controller.dtos.request.IncludeUserAccountIntoPostRequest
import com.api.socialNetwork.controller.dtos.request.LikePostRequest
import com.api.socialNetwork.controller.dtos.response.CommentResponse
import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.service.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class PostController(
    private val createNewPostService: CreateNewPostService,
    private val createNewCommentService: CreateNewCommentService,
    private val getAllCommentsFromPostService: GetAllCommentsFromPostService,
    private val  getAllLikesFromAPostService: GetAllLikesFromAPostService,
    private val includeUserAccountIntoPostService: IncludeUserAccountIntoPostService,
    private val likePostService: LikePostService
) {
    @PostMapping("/create")
    fun createPost(@RequestBody request: @Valid CreateNewPostRequest): ResponseEntity<String> {
        createNewPostService.post(request)
        return ResponseEntity.ok("You've created a post")
    }

    @PostMapping("/comment/create")
    fun createComment(@RequestBody request: @Valid CreateNewCommentRequest): ResponseEntity<String> {
        createNewCommentService.post(request)
        return ResponseEntity.ok("You've made a comment")
    }

    @GetMapping("/{id}/comments")
    fun getAllComments(@PathVariable id: Long): ResponseEntity<List<CommentResponse>> {
        val commentsResponseList = getAllCommentsFromPostService.get(id)
        return ResponseEntity.ok(commentsResponseList)
    }

    @GetMapping("/{id}/likes")
    fun getAllLikes(@PathVariable id: Long): ResponseEntity<List<UserWithPostsResponse>> {
        val get:List<UserWithPostsResponse> = getAllLikesFromAPostService.get(id)
        return ResponseEntity.ok(get)
    }

    @PutMapping("/includeNewUser")
    fun include(@RequestBody request: IncludeUserAccountIntoPostRequest): ResponseEntity<String> {
        includeUserAccountIntoPostService.includeUserAccount(request)
        return ResponseEntity.ok("You've included a user in this post")
    }

    @PostMapping("/like")
    fun like(@RequestBody request: @Valid LikePostRequest): ResponseEntity<String> {
        val response = likePostService.like(request)
        return ResponseEntity.ok(response)
    }

}