package com.api.socialNetwork.security

import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class GetUserSecurityService(private val userAccountRepository: UserAccountRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val userAccount: UserAccount = userAccountRepository.findByEmail(email)
        return SecurityUser(userAccount)
    }
}
