package com.api.socialNetwork.security

import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class FindUserAuthenticatedService(private val userAccountRepository: UserAccountRepository) {
    val user: UserAccount
        get() {
            val authentication = SecurityContextHolder.getContext().authentication
            val securityUser: SecurityUser = authentication.principal as SecurityUser
            return userAccountRepository.findById(securityUser.id).get()
        }
}
