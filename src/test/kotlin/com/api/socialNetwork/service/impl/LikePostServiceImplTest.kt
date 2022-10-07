package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.LikePost
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.LikePostRepository
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import com.api.socialNetwork.utils.factory.DateTimeFactory
import com.api.socialNetwork.utils.factory.LikePostFactory
import com.api.socialNetwork.utils.factory.PostFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class LikePostServiceImplTest {

    private val postFinderByIdImpl = Mockito.mock(PostFinderByIdImpl::class.java)
    private val findUserAuthenticatedService = Mockito.mock(FindUserAuthenticatedService::class.java)
    private val postRepository = Mockito.mock(PostRepository::class.java)
    private val likePostRepository = Mockito.mock(LikePostRepository::class.java)

    private val postCaptor = ArgumentCaptor.forClass(Post::class.java)
    private val likePostCaptor = ArgumentCaptor.forClass(LikePost::class.java)

    private val likePostServiceImpl = LikePostServiceImpl(
        postFinderByIdImpl,
        findUserAuthenticatedService,
        postRepository,
        likePostRepository
    )

    @Test
    fun like() {
        val dateTime = DateTimeFactory.getDateTime()
        val userAccount = UserAccountFactory.getUserAccount()
        val post = PostFactory.getPost(userAccount, dateTime)
        val likePostRequest = LikePostFactory.getLikePostRequest()
        val likePostExpected = LikePostFactory.getLikePost(userAccount, post)
        val postExpected = PostFactory.getPost(userAccount,dateTime)
        postExpected.likePostList.add(likePostExpected)
        postExpected.likes = 1
        val fraseExpected = "You've liked this post"

        Mockito.`when`(postFinderByIdImpl.findByIdWithException(likePostRequest.idPost)).thenReturn(post)
        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)

        val result = likePostServiceImpl.like(likePostRequest)

        Mockito.verify(postFinderByIdImpl).findByIdWithException(likePostRequest.idPost)
        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(postRepository).save(postCaptor.capture())
        Mockito.verify(likePostRepository).save(likePostCaptor.capture())

        Assertions.assertEquals(postExpected, postCaptor.value)
        Assertions.assertEquals(likePostExpected, likePostCaptor.value)
        Assertions.assertEquals(fraseExpected, result)


        Mockito.verifyNoMoreInteractions(
            postFinderByIdImpl,
            findUserAuthenticatedService,
            postRepository,
            likePostRepository
        )
    }

    @Test
    fun unlike() {
        val dateTime = DateTimeFactory.getDateTime()
        val userAccount = UserAccountFactory.getUserAccount()
        val post = PostFactory.getPost(userAccount, dateTime)
        val likePostExpected = LikePostFactory.getLikePost(userAccount, post)
        post.likePostList.add(likePostExpected)
        post.likes=1
        val likePostRequest = LikePostFactory.getLikePostRequest()
        val postExpected = PostFactory.getPost(userAccount,dateTime)
        val fraseExpected = "You've disliked this post"

        Mockito.`when`(postFinderByIdImpl.findByIdWithException(likePostRequest.idPost)).thenReturn(post)
        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)

        val result = likePostServiceImpl.like(likePostRequest)

        Mockito.verify(postFinderByIdImpl).findByIdWithException(likePostRequest.idPost)
        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(postRepository).save(postCaptor.capture())
        Mockito.verify(likePostRepository).delete(likePostCaptor.capture())

        Assertions.assertEquals(postExpected, postCaptor.value)
        Assertions.assertEquals(likePostExpected, likePostCaptor.value)
        Assertions.assertEquals(fraseExpected, result)


        Mockito.verifyNoMoreInteractions(
            postFinderByIdImpl,
            findUserAuthenticatedService,
            postRepository,
            likePostRepository
        )
    }
}