package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.mapper.PostListMapper
import com.api.socialNetwork.service.GetAllFriendsPostResponseService
import com.api.socialNetwork.service.GetAllFriendsPostService
import org.springframework.stereotype.Service

@Service
class GetAllFriendsPostResponseServiceImpl(
    private val getAllFriendsPostService: GetAllFriendsPostService,
    private val postListMapper: PostListMapper

) : GetAllFriendsPostResponseService {
    override fun get(): List<PostResponse> {
        return  getAllFriendsPostService.get().map { postListMapper.toResponse(it) }
    }
}