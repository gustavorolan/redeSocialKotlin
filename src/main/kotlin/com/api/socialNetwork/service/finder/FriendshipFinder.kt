package com.api.socialNetwork.service.finder

import com.api.socialNetwork.model.Friendship

interface FriendshipFinder {
    fun findByIdWithException(id:Long): Friendship
}
