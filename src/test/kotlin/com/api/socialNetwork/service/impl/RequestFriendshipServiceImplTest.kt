package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import com.api.socialNetwork.service.verifier.VerifierExecutor
import com.api.socialNetwork.service.verifier.requestFriendshipVerfier.RequestFriendshipVerifier
import com.api.socialNetwork.utils.factory.FriendshipFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class RequestFriendshipServiceImplTest {

    private val requestFriendshipVerifier = Mockito
        .mock(RequestFriendshipVerifier::class.java)
    private val verifierExecutor = Mockito
        .mock(VerifierExecutor::class.java)
    private val userAccountFinderByIdImpl = Mockito
        .mock(UserAccountFinderByIdImpl::class.java)
    private val findUserAuthenticatedService = Mockito
        .mock(FindUserAuthenticatedService::class.java)
    private val friendshipRepository = Mockito
        .mock(FriendshipRepository::class.java)

    private val captor = ArgumentCaptor.forClass(Friendship::class.java)

    private val requestFriendshipServiceImpl = RequestFriendshipServiceImpl(
        listOf(requestFriendshipVerifier),
        verifierExecutor,
        userAccountFinderByIdImpl,
        findUserAuthenticatedService,
        friendshipRepository
    )

    @Test
    fun request() {
        val user = UserAccountFactory.getUserAccount(1L)
        val userFriend = UserAccountFactory.getUserAccount(2L)
        val friendShipRequest = FriendshipFactory.getFriendShipRequest()
        val expected = FriendshipFactory.getFriendShip(user, userFriend)

        Mockito.`when`(userAccountFinderByIdImpl.findByIdWithException(friendShipRequest.friendId))
            .thenReturn(userFriend)
        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(user)

        requestFriendshipServiceImpl.request(friendShipRequest)

        Mockito.verify(userAccountFinderByIdImpl).findByIdWithException(friendShipRequest.friendId)
        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(friendshipRepository).save(captor.capture())
        Mockito.verify(verifierExecutor).verify(listOf(requestFriendshipVerifier), friendShipRequest)

        Assertions.assertEquals(expected,captor.value)
        println(captor.value)

        Mockito.verifyNoMoreInteractions(
            requestFriendshipVerifier,
            verifierExecutor,
            userAccountFinderByIdImpl,
            findUserAuthenticatedService,
            friendshipRepository
        )

    }
}