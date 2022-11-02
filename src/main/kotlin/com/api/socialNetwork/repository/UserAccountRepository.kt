package com.api.socialNetwork.repository

import com.api.socialNetwork.model.UserAccount
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserAccountRepository : JpaRepository<UserAccount, Long> {
    fun findByEmail(email: String?): UserAccount

    fun findByNickname(nickname: String?): UserAccount

    @Query("select u from UserAccount u where (u.username like %?1% or u.email " +
            "like %?1% or u.nickname like %?1%) and u.id not in ?2")
    fun filterAllPeopleEmailName(nameOrEmail: String, friendsIdsFromUser: List<Long>, pageable: Pageable): Page<UserAccount>
}