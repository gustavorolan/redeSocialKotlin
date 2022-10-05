package com.api.socialNetwork.controller.dtos.response

data class LikePostResponse(
     var likeId: Long,
     val userAccountResponse: UserAccountResponse
)
