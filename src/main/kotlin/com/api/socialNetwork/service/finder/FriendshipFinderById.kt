package com.api.socialNetwork.service.finder

import com.api.socialNetwork.model.Friendship

interface FriendshipFinderById {
    fun findByIdWithException(id:Long): Friendship
}
