package com.api.socialNetwork.service.verifier.requestFriendshipVerfier.impl

import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.exception.RelationAlreadyExistisException
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.verifier.requestFriendshipVerfier.RequestFriendshipVerifier
import org.springframework.stereotype.Service

@Service
class RelationAlreadyExitsVerifierImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository
) : RequestFriendshipVerifier {
    override fun verify(request: Any) {
        val userLoggedID = findUserAuthenticatedService.user.userId!!
        val acceptFriendshipRequest = request as RequestFriendshipRequest

        val filterFriendsByUserToUndoFriendship = friendshipRepository
            .filterFriendsByUserToUndoFriendship(userLoggedID, acceptFriendshipRequest.friendId)

        if(filterFriendsByUserToUndoFriendship.isNotEmpty())
            throw RelationAlreadyExistisException()
    }
}