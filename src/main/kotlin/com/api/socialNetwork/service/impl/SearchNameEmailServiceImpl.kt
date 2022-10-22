package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.SearchNameEmailService
import org.springframework.stereotype.Service


@Service
class SearchNameEmailServiceImpl(
    private var userAccountRepository: UserAccountRepository,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository,
    private val userResponseMapper: UserResponseMapper,
) : SearchNameEmailService {

    override fun search(request: SearchNameEmailRequest): List<UserAccountResponse> {
        val user: UserAccount = findUserAuthenticatedService.user

        val usersListFilteredByName = userAccountRepository
            .filterAllPeopleEmailName(request.search, user.userId!!)

        val friendships = friendshipRepository
            .filterFriendsWithoutRelationByUser(user.userId!!)
        val userFriends: MutableList<UserAccount> = ArrayList()
        friendships.stream().map(Friendship::userAccount)
            .filter { userAccount -> userAccount !== user }
            .forEach { userAccount -> userFriends.add(userAccount) }
        friendships.stream().map { friendship: Friendship -> friendship.userFriendShip }
            .filter { userAccount -> userAccount !== user }
            .forEach { userAccount -> userFriends.add(userAccount) }
        return usersListFilteredByName
            .filter { userAccount: UserAccount -> userFriends.contains(userAccount) }
            .map { userAccount: UserAccount -> userResponseMapper.toResponse(userAccount) }
    }
}