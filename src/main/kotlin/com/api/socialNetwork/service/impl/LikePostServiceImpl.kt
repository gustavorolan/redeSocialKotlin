package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.LikePostRequest
import com.api.socialNetwork.model.LikePost
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.LikePostRepository
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.LikePostService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import org.springframework.stereotype.Service

@Service
class LikePostServiceImpl(
    private val postFinderByIdImpl: PostFinderByIdImpl,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val postRepository: PostRepository,
    private val likePostRepository: LikePostRepository
) : LikePostService {
    override fun like(request: LikePostRequest): String {
        val post = postFinderByIdImpl.findByIdWithException(request.idPost) as Post
        val user = findUserAuthenticatedService.user
        val likePostList = post.likePostList
        val userThatLikedPostList = likePostList.map { it.userAccount }

         if (!userThatLikedPostList.contains(user)){
            val likePost = LikePost(user, post)
            post.likePostList.add(likePost)
            post.likes = likePostList.size
            postRepository.save(post)
            likePostRepository.save(likePost)
             return "You've liked this post"
        }
        else
        {
            val likePost = post.likePostList.find { it.userAccount == user }!!
            post.likePostList.remove(likePost)
            likePostRepository.delete(likePost)
            post.likes=post.likePostList.size
            postRepository.save(post)
            return "You've disliked this post"
        }
    }
}