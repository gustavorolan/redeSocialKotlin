package com.api.socialNetwork.repository

import com.api.socialNetwork.model.Post
import com.api.socialNetwork.model.UserAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
    @Query("select p from Post p where ?1 in p.userAccountList")
    fun findAllByUserAccountInUserAccountList(userAccountList: List<UserAccount>): List<Post>
}