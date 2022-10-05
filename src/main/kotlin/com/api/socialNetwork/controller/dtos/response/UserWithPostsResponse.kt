package com.api.socialNetwork.controller.dtos.response

data class UserWithPostsResponse(
    var userAccountResponse: UserAccountResponse,
    val postResponseList: List<PostWithUserResponse>?=ArrayList()
)
