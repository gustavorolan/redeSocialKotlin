package com.api.socialNetwork.controller

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest
import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.controller.dtos.request.UndoFriendshipRequest
import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.service.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
    private val  changeUserProfileService: ChangeUserProfileService,
    private var acceptFriendshipService: AcceptFriendshipService,
    private val  getAllRequestFriendsService: GetAllRequestFriendsService,
    private  val getFriendsResponseService: GetFriendsResponseService,
    private val getAllFriendsPostResponseService: GetAllFriendsPostResponseService,
    private val getUserService: GetUserService,
    private var requestFriendshipService: RequestFriendshipService,
    private val undoFriendshipService: UndoFriendshipService
) {
    @PutMapping("/changeUserProfile")
    fun change(@RequestBody request: ChangeUserRequest): ResponseEntity<String> {
        changeUserProfileService.change(request)
        return ResponseEntity.ok("You've changed your profile info")
    }

    @PutMapping("/acceptNewFriendship")
    fun accept(@RequestBody request: @Valid AcceptFriendshipRequest): ResponseEntity<String> {
        acceptFriendshipService.accept(request)
        return ResponseEntity.ok("You accepted the request")
    }

    @GetMapping("/getAllRequestFriends")
    fun getAllRequestFriends(): ResponseEntity<List<UserAccountResponse>> {
        val allRequestFriends:List<UserAccountResponse> = getAllRequestFriendsService.get()
        return ResponseEntity.ok(allRequestFriends)
    }

    @GetMapping("/getAllFriends")
    fun getAllFriends(): ResponseEntity<List<UserAccountResponse>> {
        val friendsResponse:List<UserAccountResponse> = getFriendsResponseService.get()
        return ResponseEntity.ok(friendsResponse);
    }

    @GetMapping("/getPostFriends")
    fun getAll(): ResponseEntity<List<PostResponse>> {
        val allFriendsPosts: List<PostResponse> = getAllFriendsPostResponseService.get()
        return ResponseEntity.ok(allFriendsPosts)
    }

    @GetMapping("/me")
    fun get(): ResponseEntity<UserAccountResponse> {
        val userAccountResponse:UserAccountResponse = getUserService.get()
        return ResponseEntity.ok(userAccountResponse)
    }

    @PostMapping("/requestNewFriendship")
    fun requestFriendship(@RequestBody request: @Valid RequestFriendshipRequest): ResponseEntity<String> {
        requestFriendshipService.request(request)
        return ResponseEntity.ok("You invited as friend")
    }

    @PutMapping("/undoFriendship")
    fun undo(@RequestBody request: @Valid UndoFriendshipRequest): ResponseEntity<String> {
        undoFriendshipService.undo(request)
        return ResponseEntity.ok("You've undid this friendship")
    }
}