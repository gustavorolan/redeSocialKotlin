package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest
import com.api.socialNetwork.model.Comment
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount


class CommentFactory {
    companion object {
        fun getComment(userAccount: UserAccount, post: Post): Comment =
            Comment(
                userAccount = userAccount,
                postCommented = post,
                commentText = "comment"
            )

        fun getCommentRequest(): CreateNewCommentRequest =
            CreateNewCommentRequest(
            postId = 1L,
            comment = "comment"
        )
    }
}