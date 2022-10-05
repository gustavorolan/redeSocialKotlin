package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.FriendshipFinder
import com.api.socialNetwork.service.finder.UserAccountFinder
import com.api.socialNetwork.service.verifier.VerifierExecutor
import javax.validation.Valid

class AcceptFriendshipServiceImpl(
    private var friendshipFinder: FriendshipFinder,
    private val friendshipRepository: FriendshipRepository,
    private val userAccountRepository: UserAccountRepository,
    private val verifierExecutor: VerifierExecutor,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val userAccountFinderById: UserAccountFinder,
)  {
    fun accept(request: @Valid AcceptFriendshipRequest) {

    }
}