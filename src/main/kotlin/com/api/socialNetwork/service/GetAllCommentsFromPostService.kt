package com.api.socialNetwork.service

import com.api.socialNetwork.controller.dtos.response.CommentResponse

interface GetAllCommentsFromPostService {
     fun get(id: Long): List<CommentResponse>
}
