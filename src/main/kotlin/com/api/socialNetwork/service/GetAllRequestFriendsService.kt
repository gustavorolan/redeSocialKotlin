package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse

interface GetAllRequestFriendsService {
    fun get(): List<UserAccountResponse>
}
