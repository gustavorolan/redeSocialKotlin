package com.api.socialNetwork.dtos.response

data class UserAccountResponse(
    val userId: Long,
    val userName: String,
    val nickName: String,
    val profileImg: String,
    val email: String,
)