package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse

interface GetAllLikesFromAPostService {
    fun get(id: Long): List<UserWithPostsResponse>
}
