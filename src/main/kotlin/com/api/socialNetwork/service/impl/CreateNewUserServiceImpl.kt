package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.service.CreateNewUserService
import com.api.socialNetwork.service.verifier.VerifierExecutor
import com.api.socialNetwork.service.verifier.createNewUserVerifier.CreateNewUserVerifier
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CreateNewUserServiceImpl(
    private val userAccountRepository: UserAccountRepository,
    private val passwordEncoder: PasswordEncoder,
    private val verifierExecutor: VerifierExecutor,
    private val createNewUserVerifierList: List<CreateNewUserVerifier>
) : CreateNewUserService {
    override fun create(request: CreateNewUserRequest): String {
        verifierExecutor.verify(createNewUserVerifierList,request)
        request.password = passwordEncoder.encode(request.password)
        val userAccount = UserAccount(request)
        userAccountRepository.save(userAccount)
        return userAccount.username
    }
}