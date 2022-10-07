package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.RequestFriendshipService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import com.api.socialNetwork.service.verifier.VerifierExecutor
import com.api.socialNetwork.service.verifier.requestFriendshipVerfier.RequestFriendshipVerifier
import org.springframework.stereotype.Service

@Service
class RequestFriendshipServiceImpl(
    private val requestFriendshipVerifier: List<RequestFriendshipVerifier>,
    private val verifierExecutor: VerifierExecutor,
    private val userAccountFinderByIdImpl: UserAccountFinderByIdImpl,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository
) : RequestFriendshipService {
    override fun request(request: RequestFriendshipRequest) {
        verifierExecutor.verify(requestFriendshipVerifier,request)
        val friendToAdd = userAccountFinderByIdImpl.findByIdWithException(request.friendId) as UserAccount
        val user = findUserAuthenticatedService.user

        val friendship = Friendship(user, friendToAdd, Relation.FRIENDS)

        friendshipRepository.save(friendship)
    }
}