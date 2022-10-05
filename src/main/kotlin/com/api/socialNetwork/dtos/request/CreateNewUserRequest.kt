package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotEmpty

data class CreateNewUserRequest(
    var username: @NotEmpty String,
    val nickname: @NotEmpty String,
    val email: @NotEmpty String,
    var password: @NotEmpty String,
    val profileImg: String = "",
)
