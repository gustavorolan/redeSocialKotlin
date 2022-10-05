package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.service.verifier.VerifierExecutor
import com.api.socialNetwork.service.verifier.createNewUserVerifier.CreateNewUserVerifier
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.springframework.security.crypto.password.PasswordEncoder

internal class CreateNewUserServiceImplTest {

    private  val userAccountRepository = Mockito
        .mock(UserAccountRepository::class.java)
    private val passwordEncoder = Mockito
        .mock(PasswordEncoder::class.java)
    private  val verifierExecutor = Mockito
        .mock(VerifierExecutor::class.java)
    private val createNewUserVerifier = Mockito
        .mock(CreateNewUserVerifier::class.java)

    private val captor = ArgumentCaptor.forClass(UserAccount::class.java)

    private val createNewUserAccountServiceImpl = CreateNewUserServiceImpl(
        userAccountRepository,
        passwordEncoder,
        verifierExecutor,
        listOf(createNewUserVerifier)
    )

    @Test
    fun create() {
        val userAccount = UserAccountFactory.getUserAccount()
        val createNewUserRequest = UserAccountFactory.getCreateNewUserRequest()

        Mockito.`when`(passwordEncoder.encode(userAccount.password)).thenReturn(userAccount.password)

        val result = createNewUserAccountServiceImpl.create(createNewUserRequest)

        Mockito.verify(verifierExecutor).verify(listOf(createNewUserVerifier),createNewUserRequest)
        Mockito.verify(passwordEncoder).encode(userAccount.password)
        Mockito.verify(userAccountRepository).save(captor.capture())

        val userSaved = captor.value

        Assertions.assertEquals(userAccount.username,result)
        Assertions.assertEquals(userAccount, userSaved)

        Mockito.verifyNoMoreInteractions(
            userAccountRepository,
            passwordEncoder,
            verifierExecutor,
            createNewUserVerifier
        )
    }
}