package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.PostResponse

interface GetAllFriendsPostResponseService {
    fun get(): List<PostResponse>
}
