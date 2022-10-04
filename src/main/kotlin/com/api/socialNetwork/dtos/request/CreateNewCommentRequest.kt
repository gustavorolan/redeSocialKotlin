package com.api.socialNetwork.dtos.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateNewCommentRequest(
    var postId: @NotNull Long,
    val comment: @NotEmpty String
)
