package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.CreateNewCommentRequest

interface CreateNewCommentService {
    fun post(request: CreateNewCommentRequest)
}
