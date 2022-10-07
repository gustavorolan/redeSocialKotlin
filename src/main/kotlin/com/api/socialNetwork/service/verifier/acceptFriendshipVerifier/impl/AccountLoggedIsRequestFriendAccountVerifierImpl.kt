package com.api.socialNetwork.service.verifier.acceptFriendshipVerifier.impl

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.verifier.acceptFriendshipVerifier.AcceptFriendshipVerifier
import org.springframework.stereotype.Component

@Component
class AccountLoggedIsRequestFriendAccountVerifierImpl(
    private val getUserAuthenticatedService: FindUserAuthenticatedService,
) : AcceptFriendshipVerifier {
    override fun verify(request: Any) {
        val requestMap: AcceptFriendshipRequest = request as AcceptFriendshipRequest
        requestMap.friendshipId
    }
}