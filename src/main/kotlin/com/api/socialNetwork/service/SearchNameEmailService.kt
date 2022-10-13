package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse

interface SearchNameEmailService {
    fun search(request: SearchNameEmailRequest): List<UserAccountResponse>
}
