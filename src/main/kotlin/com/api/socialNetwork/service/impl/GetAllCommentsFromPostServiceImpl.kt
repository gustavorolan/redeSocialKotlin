package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.CommentResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.Comment
import com.api.socialNetwork.repository.CommentRepository
import com.api.socialNetwork.service.GetAllCommentsFromPostService
import org.springframework.stereotype.Service

@Service
class GetAllCommentsFromPostServiceImpl(
    private val commentRepository:CommentRepository,
    private val userResponseMapper: UserResponseMapper
) : GetAllCommentsFromPostService {
    override fun get(id: Long): List<CommentResponse> {
        val commentList = commentRepository.findAllPostComments(id)
        val commentResponseList:MutableList<CommentResponse>  = mutableListOf()

        commentList.forEach{ comment: Comment ->
            val commentResponse = CommentResponse(
                commentText = comment.commentText,
                userAccountResponse = userResponseMapper.toResponse(user = comment.userAccount)
            )

            commentResponseList.add(commentResponse)
        }
        return commentResponseList
    }
}