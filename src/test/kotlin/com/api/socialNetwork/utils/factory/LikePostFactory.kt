package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.LikePostRequest
import com.api.socialNetwork.model.LikePost
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount

class LikePostFactory {
    companion object {
        fun getLikePost(userAccount: UserAccount, post: Post): LikePost =
            LikePost(
              userAccount =   userAccount,
              postLiked =   post
            )

        fun getLikePostRequest(): LikePostRequest =
            LikePostRequest(
                idPost = 1L
            )
    }
}