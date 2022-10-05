package com.api.socialNetwork.service

import com.api.socialNetwork.dtos.request.CreateNewUserRequest


interface CreateNewUserService {
    fun create(request:CreateNewUserRequest):String
}
