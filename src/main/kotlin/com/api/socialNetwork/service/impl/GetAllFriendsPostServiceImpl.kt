package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Environment
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetAllFriendsPostService
import com.api.socialNetwork.service.GetFriendsService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetAllFriendsPostServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val getFriendsService: GetFriendsService,
    private val postRepository: PostRepository
) : GetAllFriendsPostService {
    override fun get(page:Int): Page<Post> {
        val pageable: Pageable = PageRequest.of(page, Environment.PAGEABLE.numberOfContents)
        val user = findUserAuthenticatedService.user
        val friends= getFriendsService.get()
        val postList = mutableListOf<Long>()

        user.postList.forEach {
            postList.add(it.postId!!)
        }

        friends.forEach{friend->
            friend.postList.forEach{post: Post ->
                postList.add(post.postId!!)}
        }

        return postRepository.findFriendsPosts(postList,pageable)
    }
}