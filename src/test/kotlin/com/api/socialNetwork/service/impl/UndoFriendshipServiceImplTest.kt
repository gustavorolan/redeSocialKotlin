package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import com.api.socialNetwork.utils.factory.FriendshipFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class UndoFriendshipServiceImplTest {

    private val findUserAuthenticatedService = Mockito.mock(FindUserAuthenticatedService::class.java)
    private val userAccountFinderByIdImpl = Mockito.mock(UserAccountFinderByIdImpl::class.java)
    private val friendshipRepository = Mockito.mock(FriendshipRepository::class.java)

    private val captor = ArgumentCaptor.forClass(Friendship::class.java)

    private val undoFriendshipServiceImpl = UndoFriendshipServiceImpl(
        userAccountFinderByIdImpl,
        findUserAuthenticatedService,
        friendshipRepository,
    )

    @Test
    fun undo() {
        val userAccount = UserAccountFactory.getUserAccount(1L)
        val friendToAdd = UserAccountFactory.getUserAccount(2L)
        val undoFriendshipRequest = FriendshipFactory.getUndoFriendShipRequest(2L)
        val friendship = FriendshipFactory.getFriendShip(userAccount, friendToAdd)
        friendship.relation= Relation.FRIENDS
        val expected = Relation.BLOCKED
        Mockito.`when`(userAccountFinderByIdImpl.findByIdWithException(undoFriendshipRequest.idToUndoFriendShip)).thenReturn(friendToAdd)
        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)
        Mockito.`when`(friendshipRepository.findFirstFriendshipByUsersIdList(userAccount.userId!!, friendToAdd.userId!!)).thenReturn(friendship)

        undoFriendshipServiceImpl.undo(undoFriendshipRequest)

        Mockito.verify(userAccountFinderByIdImpl).findByIdWithException(undoFriendshipRequest.idToUndoFriendShip)
        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(friendshipRepository).findFirstFriendshipByUsersIdList(userAccount.userId!!, friendToAdd.userId!!)
        Mockito.verify(friendshipRepository).save(captor.capture())

        Assertions.assertEquals(expected,captor.value.relation)

        Mockito.verifyNoMoreInteractions(
            userAccountFinderByIdImpl,
            findUserAuthenticatedService,
            friendshipRepository,
        )
    }
}