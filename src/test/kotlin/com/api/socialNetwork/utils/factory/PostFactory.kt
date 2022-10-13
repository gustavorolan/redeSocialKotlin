package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount
import java.time.LocalDateTime

class PostFactory {
    companion object {
        fun getPost(userAccount: UserAccount, dateTime: LocalDateTime): Post =
            Post(
                userAccount = userAccount,
                privatePost = false,
                postText = "Post",
                postImg = "",
                dateTime = dateTime
            )

        fun getPost(userAccount: UserAccount, id:Long): Post {
            val post = Post(
                userAccount = userAccount,
                privatePost = false,
                postText = "Post",
                postImg = "",
                dateTime = DateTimeFactory.getDateTime()
            )

            post.postId=id

            return post
        }


        fun getCreateNewPostRequest(): CreateNewPostRequest =
            CreateNewPostRequest(
                postText = "Post",
                privatePost = false,
                PostImg = ""
            )
    }
}