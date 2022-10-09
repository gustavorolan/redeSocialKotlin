package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.IncludeUserAccountIntoPostRequest

interface IncludeUserAccountIntoPostService {
    fun includeUserAccount(request: IncludeUserAccountIntoPostRequest)
}
