package com.api.socialNetwork.dtos.request

data class ChangeUserRequest(
    val userName: String? = "",
    val nickName: String = "",
    val profileImg: String? = ""
)