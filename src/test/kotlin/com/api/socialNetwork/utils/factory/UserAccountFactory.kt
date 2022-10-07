package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.model.UserAccount


class UserAccountFactory {
    companion object {
        fun getUserAccount(): UserAccount =
            UserAccount(
                userId = null,
                username = "gustavo",
                nickname = "gus",
                email = "user@email.com",
                password = "12345678",
                profileImg = String(),
                postList = mutableListOf(),
                likePostList = mutableListOf(),
                permissionList = mutableListOf()
            )

        fun getCreateNewUserRequest(): CreateNewUserRequest =
            CreateNewUserRequest(
                username = "gustavo",
                nickname = "gus",
                email = "user@email.com",
                password = "12345678",
            )
    }

}