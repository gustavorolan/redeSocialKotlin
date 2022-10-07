package com.api.socialNetwork.controller.dtos.response

data class UserAccountResponse(
    val userId: Long,
    val username: String,
    val nickname: String,
    val profileImg: String?="",
    val email: String,
)