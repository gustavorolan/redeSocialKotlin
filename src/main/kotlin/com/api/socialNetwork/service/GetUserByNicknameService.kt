package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse

interface GetUserByNicknameService {
    fun get(nickname: String): UserAccountResponse
}
