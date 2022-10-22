package com.api.socialNetwork.repository

import com.api.socialNetwork.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
    @Query("select p from Post p where p.postId in ?1 order by p.dateTime desc")
    fun findFriendsPosts(postList: List<Long>, pageable: Pageable): Page<Post>

    @Query("select p from Post p where p.postId in ?1 order by p.dateTime desc")
    fun findFriendsPostsList(postList: List<Long>): List<Post>
    // @Query("select p from Post p where p.userAccountList.userId in ?1")
   // fun findAllByUserAccountInUserAccountList(userAccountList: List<Long>): List<Post>
}