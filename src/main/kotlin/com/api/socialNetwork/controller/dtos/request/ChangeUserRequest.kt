package com.api.socialNetwork.controller.dtos.request

data class ChangeUserRequest(
    val userName: String? = "",
    val nickName: String = "",
    val profileImg: String? = ""
)