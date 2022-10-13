package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse

interface GetUserWithPostsByNicknameService {
    fun get(nickname: String): UserWithPostsResponse

}
