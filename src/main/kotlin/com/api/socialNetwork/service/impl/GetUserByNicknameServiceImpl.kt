package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.service.GetUserByNicknameService
import org.springframework.stereotype.Service

@Service
class GetUserByNicknameServiceImpl(
    private val userAccountRepository: UserAccountRepository,
    private val userResponseMapper: UserResponseMapper
) : GetUserByNicknameService {
    override fun get(nickname: String): UserAccountResponse {
        val user = userAccountRepository.findByNickname(nickname)
        return userResponseMapper.toResponse(user)
    }
}