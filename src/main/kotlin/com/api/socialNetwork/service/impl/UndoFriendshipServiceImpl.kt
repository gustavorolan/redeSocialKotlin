package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.UndoFriendshipRequest
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.UndoFriendshipService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import org.springframework.stereotype.Service

@Service
class UndoFriendshipServiceImpl(
    private val userAccountFinderByIdImpl: UserAccountFinderByIdImpl,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository
) : UndoFriendshipService {
    override fun undo(request: UndoFriendshipRequest) {
        val user = findUserAuthenticatedService.user
        val userToAdd = userAccountFinderByIdImpl.findByIdWithException(request.idToUndoFriendShip) as UserAccount
        val friendship = friendshipRepository.findFirstFriendshipByUsersIdList(user.id!!, userToAdd.id!!)
        friendship.relation = Relation.BLOCKED
        friendshipRepository.save(friendship)
    }
}