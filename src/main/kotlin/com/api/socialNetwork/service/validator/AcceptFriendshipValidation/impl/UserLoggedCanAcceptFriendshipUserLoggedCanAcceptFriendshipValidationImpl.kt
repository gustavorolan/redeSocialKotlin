package com.api.socialNetwork.service.validator.AcceptFriendshipValidation.impl

import com.api.socialNetwork.exception.UserLoggedCanAcceptFriendshipException
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.validator.AcceptFriendshipValidation.UserLoggedCanAcceptFriendshipValidation
import org.springframework.stereotype.Service

@Service
class UserLoggedCanAcceptFriendshipUserLoggedCanAcceptFriendshipValidationImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService
) : UserLoggedCanAcceptFriendshipValidation {
    override fun validate(objectToBeValidated: Any) {
        val userLogged = findUserAuthenticatedService.user
        val friendUserId = objectToBeValidated as Long
        if(userLogged.userId!! != friendUserId) throw UserLoggedCanAcceptFriendshipException()
    }
}