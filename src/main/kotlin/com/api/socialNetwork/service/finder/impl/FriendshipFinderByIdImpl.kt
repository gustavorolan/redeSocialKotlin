package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.FriendshipNotFoundedException
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.service.finder.FinderById
import org.springframework.stereotype.Service

@Service
class FriendshipFinderByIdImpl(
    private val friendshipRepository: FriendshipRepository,
) : FinderById {
    override fun findByIdWithException(id: Long):Any = friendshipRepository
        .findById(id).orElseThrow{ FriendshipNotFoundedException() }
}