package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class ChangeUserProfileServiceImplTest {
    private val findUserAuthenticatedService = Mockito.mock(FindUserAuthenticatedService::class.java)
    private val userAccountRepository = Mockito.mock(UserAccountRepository::class.java)

    private val captor = ArgumentCaptor.forClass(UserAccount::class.java)

    private val changeUserServiceImpl = ChangeUserProfileServiceImpl(
        findUserAuthenticatedService,
        userAccountRepository
    )

    @Test
    fun change() {
        val userAccount = UserAccountFactory.getUserAccount()
        val expected = UserAccountFactory.getChangeProfileInfoUserAccountExpected()
        val changeProfileInfoRequest = UserAccountFactory.getChangeProfileInfoRequest()

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)

       changeUserServiceImpl.change(changeProfileInfoRequest)

        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(userAccountRepository).save(captor.capture())

        Assertions.assertEquals(expected,captor.value)

        Mockito.verifyNoMoreInteractions(
            findUserAuthenticatedService,
            userAccountRepository
        )
    }
}