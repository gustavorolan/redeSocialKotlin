package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.ChangeUserRequest

interface ChangeUserProfileService {
    fun change(request: ChangeUserRequest)
}
