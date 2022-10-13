package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Post
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetAllFriendsPostService
import com.api.socialNetwork.service.GetFriendsService
import org.springframework.stereotype.Service

@Service
class GetAllFriendsPostServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val getFriendsService: GetFriendsService
) : GetAllFriendsPostService {
    override fun get(): List<Post> {
        val user = findUserAuthenticatedService.user
        val friends= getFriendsService.get()
        val postList = mutableListOf<Post>()

        user.postList.forEach(postList::add)
        friends.forEach{friend -> friend.postList.forEach(postList::add)}

        return postList
    }
}