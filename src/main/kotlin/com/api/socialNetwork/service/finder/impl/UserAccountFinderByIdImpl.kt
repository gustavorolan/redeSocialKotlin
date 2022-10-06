package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.UserAccountNotFoundedException
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.service.finder.FinderById
import org.springframework.stereotype.Service

@Service
class UserAccountFinderByIdImpl(
    private val userAccountRepository: UserAccountRepository
    ) : FinderById {
    override fun findByIdWithException(id: Long):Any = userAccountRepository
        .findById(id).orElseThrow{ UserAccountNotFoundedException() }
}