package com.api.socialNetwork.dtos.response

data class LikePostResponse(
     var likeId: Long,
     val userAccountResponse: UserAccountResponse
)
