package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest


interface CreateNewUserService {
    fun create(request: CreateNewUserRequest):String
}
