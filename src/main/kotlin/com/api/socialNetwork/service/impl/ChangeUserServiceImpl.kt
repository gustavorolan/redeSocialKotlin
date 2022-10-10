package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.ChangeUserService
import org.springframework.stereotype.Service

@Service
class ChangeUserServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val userAccountRepository: UserAccountRepository
) : ChangeUserService {
    override fun change(request: ChangeUserRequest) {
        val user: UserAccount = findUserAuthenticatedService.user

        if (request.username!!.isNotBlank()) user.username = request.username
        if (request.profileImg!!.isNotBlank()) user.profileImg=request.profileImg
        if (request.nickname!!.isNotBlank()) user.nickname=request.nickname

        userAccountRepository.save(user)
    }
}