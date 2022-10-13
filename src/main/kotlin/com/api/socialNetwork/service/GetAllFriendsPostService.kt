package com.api.socialNetwork.service

import com.api.socialNetwork.model.Post

interface GetAllFriendsPostService {
    fun get(): List<Post>
}
