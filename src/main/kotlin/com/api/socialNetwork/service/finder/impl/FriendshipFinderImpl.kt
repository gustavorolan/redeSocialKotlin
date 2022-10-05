package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.FriendshipNotFoundedException
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.service.finder.FriendshipFinder
import org.springframework.stereotype.Service

@Service
class FriendshipFinderImpl(
    private val friendshipRepository: FriendshipRepository
) : FriendshipFinder {
     override
     fun findByIdWithException(id: Long): Friendship = friendshipRepository
         .findById(id).orElseThrow { FriendshipNotFoundedException() }
}