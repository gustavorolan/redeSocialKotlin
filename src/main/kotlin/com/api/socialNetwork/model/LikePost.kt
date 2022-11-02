package com.api.socialNetwork.model

import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class LikePost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeId")
    var id: Long? = null,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "postId")
    val postLiked: Post,
){
    constructor(
        userAccount: UserAccount,
        postLiked: Post
    ):this(
       id = null,
       userAccount =  userAccount,
       postLiked =  postLiked
    )
}
