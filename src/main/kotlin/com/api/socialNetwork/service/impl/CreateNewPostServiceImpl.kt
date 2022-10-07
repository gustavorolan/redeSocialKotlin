package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.CreateNewPostService
import com.api.socialNetwork.service.LocalDateAndTime
import org.springframework.stereotype.Service

@Service
class CreateNewPostServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val localDateAndTime: LocalDateAndTime,
    private val postRepository: PostRepository
) : CreateNewPostService {
    override fun post(request: CreateNewPostRequest) {
        val userAccount:UserAccount = findUserAuthenticatedService.user

        val post = Post(
            userAccount,
            request.privatePost,
            request.postText,
            request.PostImg!!,
            localDateAndTime.get()
        )

        userAccount.postList.add(post)

        postRepository.save(post)
    }
}