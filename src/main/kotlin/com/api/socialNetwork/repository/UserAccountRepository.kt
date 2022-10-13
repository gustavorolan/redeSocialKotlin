package com.api.socialNetwork.repository

import com.api.socialNetwork.model.UserAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserAccountRepository : JpaRepository<UserAccount, Long> {
    fun findByEmail(email: String?): UserAccount

    fun findByNickname(nickname: String?): UserAccount

    @Query(
        "select u from UserAccount u where " +
                " (u.username like %?1% or u.email like %?1%  " +
                "or u.nickname like %?1%)and not u.userId=?2 "
    )
    fun filterAllPeopleEmailName(nameOrEmail: String, userId: Long): List<UserAccount>
}