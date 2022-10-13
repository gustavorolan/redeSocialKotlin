package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.service.GetFriendsResponseService
import com.api.socialNetwork.service.GetFriendsService
import org.springframework.stereotype.Service

@Service
class GetFriendsResponseServiceImpl(
    private val getFriendsService:GetFriendsService,
    private val userResponseMapper: UserResponseMapper
) : GetFriendsResponseService {
    override fun get(): List<UserAccountResponse> {
            return userResponseMapper.toResponse(getFriendsService.get())
    }
}