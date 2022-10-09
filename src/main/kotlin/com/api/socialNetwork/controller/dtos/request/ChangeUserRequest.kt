package com.api.socialNetwork.controller.dtos.request

data class ChangeUserRequest(
    val username: String? = "",
    val nickname: String? = "",
    val profileImg: String? = ""
)