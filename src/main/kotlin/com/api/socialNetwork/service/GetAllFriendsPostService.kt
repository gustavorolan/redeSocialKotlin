package com.api.socialNetwork.service

import com.api.socialNetwork.model.Post
import org.springframework.data.domain.Page

interface GetAllFriendsPostService {
    fun get(page: Int): Page<Post>
}
