package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.exception.UserAccountNotFoundedException
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.service.finder.UserAccountFinder
import org.springframework.stereotype.Service

@Service
class UserAccountFinderImpl(private val userAccountRepository: UserAccountRepository) : UserAccountFinder {
    override fun findByIdWithException(id: Long): UserAccount = userAccountRepository
        .findById(id).orElseThrow { UserAccountNotFoundedException() }
}