package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.CreateNewPostRequest
import javax.validation.Valid

interface CreateNewPostService {
    fun post(request: @Valid CreateNewPostRequest)
}
