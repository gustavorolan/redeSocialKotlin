package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetFriendsService
import org.springframework.stereotype.Service

@Service
class GetFriendsServiceImpl(
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository
) : GetFriendsService {
    override fun get(): List<UserAccount> {
        val user = findUserAuthenticatedService.user
        val friendshipsWithBothUsers = friendshipRepository.filterFriendsByUser(user.userId!!, Relation.FRIENDS);
        val friends : MutableList <UserAccount>  = mutableListOf()
        friendshipsWithBothUsers.forEach{friendship ->
            if (friendship.userAccount != user) friends.add(friendship.userAccount)
            if (friendship.userFriendShip != user) friends.add(friendship.userFriendShip)
        }
        return friends
    }
}