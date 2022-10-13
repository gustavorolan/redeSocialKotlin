package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest
import com.api.socialNetwork.model.Comment
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.CommentRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.CreateNewCommentService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import org.springframework.stereotype.Service

@Service
class CreateNewCommentServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,

    private val commentRepository: CommentRepository,

    private val postFinderByIdImpl: PostFinderByIdImpl
) : CreateNewCommentService {

    override fun post(request: CreateNewCommentRequest) {
        val user: UserAccount = findUserAuthenticatedService.user
        val post = postFinderByIdImpl.findByIdWithException(request.postId) as Post
        val comment = Comment(
            user,
            post,
            request.comment
        )

        post.commentList.add(comment)
        post.comments=post.commentList.size

        commentRepository.save(comment)
    }
}