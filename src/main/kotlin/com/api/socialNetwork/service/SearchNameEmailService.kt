package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import org.springframework.data.domain.Page

interface SearchNameEmailService {
    fun search(request: SearchNameEmailRequest): Page<UserAccountResponse>
}
