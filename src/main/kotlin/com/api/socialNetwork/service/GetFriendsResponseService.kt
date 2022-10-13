package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse

interface GetFriendsResponseService {
    fun get(): List<UserAccountResponse>
}
