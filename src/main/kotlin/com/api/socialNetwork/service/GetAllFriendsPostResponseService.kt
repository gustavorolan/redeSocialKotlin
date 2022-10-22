package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.PostResponse
import org.springframework.data.domain.Page

interface GetAllFriendsPostResponseService {
    fun get(page: Int): Page<PostResponse>
}
