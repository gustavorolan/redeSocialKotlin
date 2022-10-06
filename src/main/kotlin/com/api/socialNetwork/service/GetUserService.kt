package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import org.springframework.stereotype.Service

@Service
interface GetUserService {
    fun get():UserAccountResponse
}
