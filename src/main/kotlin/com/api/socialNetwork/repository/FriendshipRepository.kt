package com.api.socialNetwork.repository

import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.Relation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface FriendshipRepository : JpaRepository<Friendship, Long> {
    @Query(
        "select f from Friendship f where" +
                " (f.userAccount.id=?1 or f.userFriendShip.id=?1)" +
                "and f.relation=?2 "
    )
    fun filterFriendsByUser(userId: Long, relation: Relation): List<Friendship>

    @Query(
        ("select f from Friendship f where " +
                "((f.userAccount.id=?1 " +
                "and f.userFriendShip.id=?2)" +
                "or(f.userAccount.id=?2 " +
                "and f.userFriendShip.id=?1))")
    )
    fun filterFriendsByUsersId(userId: Long, userToUndo: Long): List<Friendship>

    @Query(
        ("select f from Friendship f where " +
                "((f.userAccount.id=?1 " +
                "and f.userFriendShip.id=?2)" +
                "or(f.userAccount.id=?2 " +
                "and f.userFriendShip.id=?1))")
    )
    fun findFirstFriendshipByUsersIdList(userId: Long, userToUndo: Long): Friendship
}
