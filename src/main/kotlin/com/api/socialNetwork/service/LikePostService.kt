package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.LikePostRequest

interface LikePostService {
    fun like(request: LikePostRequest):String
}
