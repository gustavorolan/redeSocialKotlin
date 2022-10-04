package com.api.socialNetwork.dtos.response

import java.time.LocalDateTime

data class PostWithUserResponse(
     val postId: Long,

     val postText: String,

     val postImg: String,

     val likes: Int,

     val dateTime: LocalDateTime,

     val comments: Int,

     val userAccountResponseList: List<UserAccountResponse>,

     var userAccountResponse: UserAccountResponse?
)