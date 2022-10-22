package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.PostResponse
import com.api.socialNetwork.mapper.PostListMapper
import com.api.socialNetwork.model.Environment
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.service.GetAllFriendsPostResponseService
import com.api.socialNetwork.service.GetAllFriendsPostService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetAllFriendsPostResponseServiceImpl(
    private val getAllFriendsPostService: GetAllFriendsPostService,
    private val postListMapper: PostListMapper,
    private val postRepository: PostRepository

) : GetAllFriendsPostResponseService {
    override fun get(page:Int): Page<PostResponse> {
        val pageable: Pageable = PageRequest.of(page, Environment.PAGEABLE.numberOfContents)
        val postIds = getAllFriendsPostService.get(page)
        val findFriendsPosts = postRepository.findFriendsPosts(postIds, pageable)
        return  findFriendsPosts.map { postListMapper.toResponse(it) }
    }
}