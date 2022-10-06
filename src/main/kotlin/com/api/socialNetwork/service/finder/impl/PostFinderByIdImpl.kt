package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.PostNotFoundedException
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.service.finder.FinderById
import org.springframework.stereotype.Service

@Service
class PostFinderByIdImpl(
    private val postRepository: PostRepository
):FinderById {
    override fun findByIdWithException(id: Long):Any = postRepository
        .findById(id).orElseThrow{ PostNotFoundedException() }
}
