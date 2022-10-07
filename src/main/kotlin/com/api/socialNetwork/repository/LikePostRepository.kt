package com.api.socialNetwork.repository

import com.api.socialNetwork.model.LikePost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LikePostRepository : JpaRepository<LikePost, Long> {
    @Query("select l from LikePost l where l.postLiked.postId=?1")
    fun filterAllLikesOfPostId(postID: Long): List<LikePost>
}