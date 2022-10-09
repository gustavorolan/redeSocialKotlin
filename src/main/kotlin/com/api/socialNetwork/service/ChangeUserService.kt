package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest

interface ChangeUserService {
    fun change(request: ChangeUserRequest)
}
