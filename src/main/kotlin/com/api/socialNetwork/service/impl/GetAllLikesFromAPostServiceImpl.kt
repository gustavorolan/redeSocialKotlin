package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.LikePost
import com.api.socialNetwork.repository.LikePostRepository
import com.api.socialNetwork.service.GetAllLikesFromAPostService
import org.springframework.stereotype.Service

@Service
class GetAllLikesFromAPostServiceImpl(
    private val likePostRepository: LikePostRepository,
    private val userResponseMapper: UserResponseMapper
    ) : GetAllLikesFromAPostService {
    override fun get(id: Long): List<UserWithPostsResponse> {
        val likesFromPost = likePostRepository.filterAllLikesOfPostId(id)
        return likesFromPost.map { likePost: LikePost ->
            userResponseMapper.toResponseWithPosts(likePost.userAccount)
        }
    }
}