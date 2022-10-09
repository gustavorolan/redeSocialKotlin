package com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.impl

import com.api.socialNetwork.exception.MaxPlayersLimitException
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.IncludeUserAccountIntoPostValidation
import org.springframework.stereotype.Component

@Component
class MaxPlayersLimitExceptionValidationImpl : IncludeUserAccountIntoPostValidation {
    override fun validate(post: Post) {
        if (post.userAccountList.size > 4) {
            throw MaxPlayersLimitException()
        }
    }
}