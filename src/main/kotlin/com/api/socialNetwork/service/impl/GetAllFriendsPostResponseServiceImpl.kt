package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.mapper.PostListMapper
import com.api.socialNetwork.service.GetAllFriendsPostResponseService
import com.api.socialNetwork.service.GetAllFriendsPostService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class GetAllFriendsPostResponseServiceImpl(
    private val getAllFriendsPostService: GetAllFriendsPostService,
    private val postListMapper: PostListMapper

) : GetAllFriendsPostResponseService {
    override fun get(page:Int): Page<PostResponse> {
        return  getAllFriendsPostService.get(page).map { postListMapper.toResponse(it) }
    }
}