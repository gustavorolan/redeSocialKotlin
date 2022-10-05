package com.api.socialNetwork.service.verifier

import com.api.socialNetwork.dtos.request.AcceptFriendshipRequest

interface Verifier {
    fun verify(request:Any)
}