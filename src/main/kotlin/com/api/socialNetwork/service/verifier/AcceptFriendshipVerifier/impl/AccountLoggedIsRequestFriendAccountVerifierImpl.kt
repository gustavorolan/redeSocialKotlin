package com.api.socialNetwork.service.verifier.AcceptFriendshipVerifier.impl

import com.api.socialNetwork.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.verifier.AcceptFriendshipVerifier.AcceptFriendshipVerifier
import org.springframework.stereotype.Component

@Component
class AccountLoggedIsRequestFriendAccountVerifierImpl(
    private val getUserAuthenticatedService: FindUserAuthenticatedService,
) : AcceptFriendshipVerifier {
    override fun verify(request: Any) {
        val requestMap:AcceptFriendshipRequest = request as AcceptFriendshipRequest
        requestMap.friendshipId
    }
}