package com.api.socialNetwork.service.validator

interface UserLoggedCanAcceptFriendshipValidation {
    fun validate(objectToBeValidated: Long)
}