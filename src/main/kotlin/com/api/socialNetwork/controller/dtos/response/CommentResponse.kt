package com.api.socialNetwork.controller.dtos.response

data class CommentResponse(
           var commentText: String,
            val userAccountResponse: UserAccountResponse
)
