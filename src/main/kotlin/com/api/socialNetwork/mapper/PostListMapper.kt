package com.api.socialNetwork.mapper

import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.controller.dtos.response.PostWithUserResponse
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.model.Post
import org.springframework.stereotype.Component

@Component
class PostListMapper(private val userResponseMapper: UserResponseMapper) {

    fun toResponse(post: Post): PostResponse {

        val userAccountResponseList: List<UserAccountResponse> = userAccountResponses(post)

        return PostResponse(
            postId = post.postId!!,
            userAccountResponse = userAccountResponseList,
            postText = post.postText!!,
            postImg = post.postImg!!,
            likes = post.likes!!,
            dateTime = post.dateTime!!,
            comments = post.comments!!,
        )
    }

    fun postWithoutUserToResponse(post: Post): PostWithUserResponse {

        val userAccountResponseList: List<UserAccountResponse> = userAccountResponses(post)

        return PostWithUserResponse(
            postId = post.postId!!,
            postText = post.postText!!,
            postImg = post.postImg!!,
            likes = post.likes!!,
            dateTime = post.dateTime!!,
            comments = post.comments!!,
            userAccountResponseList = userAccountResponseList,
            userAccountResponse = null,
        )
    }

    private fun userAccountResponses(post: Post): List<UserAccountResponse> {
        return post.userAccountList!!
            .map { userAccount -> userResponseMapper.toResponse(userAccount) }
    }
}