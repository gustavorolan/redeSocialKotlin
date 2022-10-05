package com.api.socialNetwork.mapper

import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import com.api.socialNetwork.model.Post
import org.springframework.stereotype.Component

@Component
class CreateNewPostMapper {
    fun toEntity(request: CreateNewPostRequest): Post {
        return Post(
            postImg = request.PostImg,
            postText = request.postText,
            privatePost = request.privatePost
        )
    }
}