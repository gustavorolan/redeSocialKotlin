package com.api.socialNetwork.controller.dtos.response

data class UserWithPostsResponse(
    var userAccountResponse: UserAccountResponse,
    var postResponseList: List<PostWithUserResponse> ?= mutableListOf()
)
