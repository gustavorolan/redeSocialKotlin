package com.api.socialNetwork.security

import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class FindUserAuthenticatedService(
    private val userAccountFinderByIdImpl: UserAccountFinderByIdImpl
    ) {
    val user: UserAccount
        get() {
            val authentication = SecurityContextHolder.getContext().authentication
            val securityUser: SecurityUser = authentication.principal as SecurityUser
            return userAccountFinderByIdImpl.findByIdWithException(securityUser.id) as UserAccount
        }
}
