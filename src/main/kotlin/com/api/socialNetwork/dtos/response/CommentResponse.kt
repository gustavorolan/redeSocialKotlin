package com.api.socialNetwork.dtos.response

data class CommentResponse(
           var commentText: String,
            val userAccountResponse: UserAccountResponse
)
