package com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation

import com.api.socialNetwork.model.Post

interface IncludeUserAccountIntoPostValidation {
    fun validate(post:Post)
}