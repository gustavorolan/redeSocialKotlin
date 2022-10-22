package com.api.socialNetwork.service.validator.impl

import com.api.socialNetwork.exception.UserLoggedCanAcceptFriendshipException
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.validator.UserLoggedCanAcceptFriendshipValidation
import org.springframework.stereotype.Service

@Service
class UserLoggedCanAcceptFriendshipUserLoggedCanAcceptFriendshipValidationImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService
) : UserLoggedCanAcceptFriendshipValidation {
    override fun validate(objectToBeValidated: Long) {
        val userLogged = findUserAuthenticatedService.user
        val friendUserId = objectToBeValidated
        if(userLogged.userId!! != friendUserId) throw UserLoggedCanAcceptFriendshipException()
    }
}