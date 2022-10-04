package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.FriendshipNotFoundedException
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.service.finder.FriendshipFinderById
import org.springframework.stereotype.Service

@Service
class FriendshipFinderByIdImpl(
    private val friendshipRepository: FriendshipRepository
) : FriendshipFinderById {
     override
     fun findByIdWithException(id: Long): Friendship {
        return friendshipRepository.findById(id)
            .orElseThrow { FriendshipNotFoundedException() }

    }
}