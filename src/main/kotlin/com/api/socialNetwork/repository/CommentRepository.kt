package com.api.socialNetwork.repository

import com.api.socialNetwork.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.postCommented.postId=?1")
    fun findAllPostComments(postId: Long): List<Comment>
}
