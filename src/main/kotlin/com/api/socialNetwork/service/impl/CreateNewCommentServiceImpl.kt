package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest
import com.api.socialNetwork.model.Comment
import com.api.socialNetwork.model.Notification
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.CommentRepositoryInterface
import com.api.socialNetwork.repository.NotificationRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.CreateNewCommentService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import org.springframework.stereotype.Service

@Service
class CreateNewCommentServiceImpl(
    private val userAccountRepository: UserAccountRepository,

    private val findUserAuthenticatedService: FindUserAuthenticatedService,

    private val commentRepository: CommentRepositoryInterface,

    private val notificationRepository: NotificationRepository,

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

        commentRepository.save(comment)

        val notification = Notification(
            user,
            "${user.username} comentou no seu post"
        )

        val usersToNotify: MutableList<UserAccount> = post.userAccountList

        usersToNotify.stream().forEach{ userToNotify: UserAccount ->
            userToNotify.notificationList.add(notification)
            userAccountRepository.save(userToNotify)
        }

        notificationRepository.save(notification)
    }
}