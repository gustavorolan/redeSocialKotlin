package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.IncludeUserAccountIntoPostRequest
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.IncludeUserAccountIntoPostService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.IncludeUserAccountIntoPostValidation

class IncludeUserAccountIntoPostServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val postFinderByIdImpl: PostFinderByIdImpl,
    private val postRepository: PostRepository,
    private val includeUserAccountIntoPostValidationList:List<IncludeUserAccountIntoPostValidation>
) : IncludeUserAccountIntoPostService {
    override fun includeUserAccount(request: IncludeUserAccountIntoPostRequest) {
        val user = findUserAuthenticatedService.user
        val post = postFinderByIdImpl.findByIdWithException(request.idPost) as Post

        includeUserAccountIntoPostValidationList
            .forEach{validation-> validation.validate(post)}

        post.userAccountList.add(user)
        user.postList.add(post)

        postRepository.save(post)
    }
}