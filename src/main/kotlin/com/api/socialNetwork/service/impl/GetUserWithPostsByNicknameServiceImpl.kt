package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.PostWithUserResponse
import com.api.socialNetwork.controller.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.mapper.PostListMapper
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetUserWithPostsByNicknameService
import org.springframework.stereotype.Service

@Service
class GetUserWithPostsByNicknameServiceImpl(
    private var userAccountRepository: UserAccountRepository,
    private val userResponseMapper: UserResponseMapper,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository,
    private val postListMapper: PostListMapper,
) : GetUserWithPostsByNicknameService {
    override fun get(nickname: String): UserWithPostsResponse {
        val user = findUserAuthenticatedService.user
        val personSearched = userAccountRepository.findByNickname(nickname)
        val friendship = friendshipRepository.filterFriendsByUsersId(user.id!!, personSearched.id!!)
        val postWithUser: MutableList<PostWithUserResponse> = mutableListOf()


        if (friendship.isEmpty()) {
            personSearched.postList.filter { !it.privatePost }.forEach { postWithUser.add(postListMapper.postWithoutUserToResponse(it)) }
        } else {
            personSearched.postList.forEach { postWithUser.add(postListMapper.postWithoutUserToResponse(it)) }
        }


        val toResponseWithPosts = userResponseMapper.toResponseWithPosts(personSearched)
        toResponseWithPosts.postResponseList = postWithUser

        return toResponseWithPosts
    }
}