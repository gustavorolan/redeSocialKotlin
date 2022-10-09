package com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.impl

import com.api.socialNetwork.exception.AlreadyInGameException
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.IncludeUserAccountIntoPostValidation
import org.springframework.stereotype.Service

@Service
class IncludeUserAccountIntoPostValidationImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService
) : IncludeUserAccountIntoPostValidation {
    override fun validate(post: Post) {
        if(post.userAccountList.contains(findUserAuthenticatedService.user))
            throw AlreadyInGameException()
    }
}