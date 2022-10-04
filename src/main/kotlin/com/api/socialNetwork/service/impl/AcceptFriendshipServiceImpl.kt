package com.api.socialNetwork.service.impl

import com.api.socialNetwork.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.FriendshipFinderById
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.Valid

class AcceptFriendshipServiceImpl(
    private var friendshipFinderById: FriendshipFinderById,
    private val friendshipRepository: FriendshipRepository,
    private val userAccountRepository: UserAccountRepository,
    private val verifyIfAccountLoggedIsRequestFriendAccountService: VerifyIfAccountLoggedIsRequestFriendAccountService,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val userAccountFinderById: UserAccountFinderById,
)  {
    fun accept(request: @Valid AcceptFriendshipRequest) {
        TODO("Not yet implemented")
    }
}