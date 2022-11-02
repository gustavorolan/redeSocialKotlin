package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest
import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.model.UserAccount


class UserAccountFactory {
    companion object {
        fun getUserAccount(): UserAccount =
            UserAccount(
                id = null,
                username = "gustavo",
                nickname = "gus",
                email = "user@email.com",
                password = "12345678",
                profileImg = String(),
                postList = mutableListOf(),
                likePostList = mutableListOf(),
                permissionList = mutableListOf()
            )

         fun getUserAccount(username:String, nickname:String, profileImg:String): UserAccount =
            UserAccount(
                id = null,
                username = username,
                nickname = nickname,
                email = "user@email.com",
                password = "12345678",
                profileImg = profileImg,
                postList = mutableListOf(),
                likePostList = mutableListOf(),
                permissionList = mutableListOf()
            )

        fun getUserAccount(userId: Long): UserAccount =
            UserAccount(
                id = userId,
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

        fun getUserAccountResponse(): UserAccountResponse =
            UserAccountResponse(
                userId = 1L,
                username = "gustavo",
                nickname = "gus",
                email = "user@email.com",
            )

        fun getChangeProfileInfoRequest(): ChangeUserRequest =
            ChangeUserRequest(
                username = "username",
                nickname = "user",
                profileImg = "foto"
            )

        fun getChangeProfileInfoUserAccountExpected(): UserAccount {
            return getUserAccount("username","user","foto")
        }
    }

}