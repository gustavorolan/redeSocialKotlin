package com.api.socialNetwork.service.finder.impl

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetUserService
import org.springframework.stereotype.Service

@Service
class GetUserServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val userResponseMapper: UserResponseMapper
) : GetUserService {
    override fun get(): UserAccountResponse {
        val user: UserAccount = findUserAuthenticatedService.user
        return userResponseMapper.toResponse(user)
    }
}