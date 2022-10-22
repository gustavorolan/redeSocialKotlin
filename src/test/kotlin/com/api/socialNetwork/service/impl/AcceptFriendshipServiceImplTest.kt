package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import com.api.socialNetwork.service.validator.AcceptFriendshipValidation.UserLoggedCanAcceptFriendshipValidation
import com.api.socialNetwork.utils.factory.FriendshipFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class AcceptFriendshipServiceImplTest {

    private val findUserAuthenticatedService = Mockito.mock(FindUserAuthenticatedService::class.java)
    private val userAccountFinderByIdImpl = Mockito.mock(UserAccountFinderByIdImpl::class.java)
    private val friendshipRepository = Mockito.mock(FriendshipRepository::class.java)
    private val userLoggedCanAcceptFriendshipValidation = Mockito.mock(UserLoggedCanAcceptFriendshipValidation::class.java)

    private val captor = ArgumentCaptor.forClass(Friendship::class.java)

    private val acceptFriendshipService = AcceptFriendshipServiceImpl(
        findUserAuthenticatedService,
        userAccountFinderByIdImpl,
        friendshipRepository,
        userLoggedCanAcceptFriendshipValidation
    )

    @Test
    fun accept() {
        val userAccount = UserAccountFactory.getUserAccount(1L)
        val friendToAdd = UserAccountFactory.getUserAccount(2L)
        val acceptFriendShipRequest = FriendshipFactory.getAcceptFriendShipRequest(2L)
        val friendship = FriendshipFactory.getFriendShip(userAccount, friendToAdd)
        friendship.relation=Relation.NOT_FRIENDS
        val expected = Relation.FRIENDS
        Mockito.`when`(userAccountFinderByIdImpl.findByIdWithException(acceptFriendShipRequest.friendId)).thenReturn(friendToAdd)
        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)
        Mockito.`when`(friendshipRepository.findFirstFriendshipByUsersIdList(userAccount.userId!!, friendToAdd.userId!!)).thenReturn(friendship)

        acceptFriendshipService.accept(acceptFriendShipRequest)

        Mockito.verify(userAccountFinderByIdImpl).findByIdWithException(acceptFriendShipRequest.friendId)
        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(friendshipRepository).findFirstFriendshipByUsersIdList(userAccount.userId!!, friendToAdd.userId!!)
        Mockito.verify(userLoggedCanAcceptFriendshipValidation).validate(friendship)
        Mockito.verify(friendshipRepository).save(captor.capture())

        Assertions.assertEquals(expected,captor.value.relation)

        Mockito.verifyNoMoreInteractions(
            findUserAuthenticatedService,
            userAccountFinderByIdImpl,
            friendshipRepository,
            userLoggedCanAcceptFriendshipValidation
        )
    }
}