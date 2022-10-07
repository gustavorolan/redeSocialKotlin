package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.LikePostRequest

interface LikeAPostService {
    fun like(request: LikePostRequest):String
}
