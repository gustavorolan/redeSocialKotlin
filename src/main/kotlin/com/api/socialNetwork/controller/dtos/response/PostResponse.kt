package com.api.socialNetwork.controller.dtos.response

import java.time.LocalDateTime

data class PostResponse(
    var postId: Long,
    val postText: String,
    val postImg: String,
    val likes: Int,
    val dateTime: LocalDateTime,
    val comments: Int,
    val userAccountResponse: List<UserAccountResponse>,
)
