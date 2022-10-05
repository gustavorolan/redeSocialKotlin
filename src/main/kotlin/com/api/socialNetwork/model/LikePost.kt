package com.api.socialNetwork.model

import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class LikePost(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var likeId: Long? = null,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "postId")
    val postLiked: Post,
)
