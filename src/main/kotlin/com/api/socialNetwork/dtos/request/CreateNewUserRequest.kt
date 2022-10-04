package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotEmpty

data class CreateNewUserRequest(
    var userName: @NotEmpty String,
    val nickName: @NotEmpty String,
    val email: @NotEmpty String,
    val password: @NotEmpty String,
    val profileImg: String = "",
)
