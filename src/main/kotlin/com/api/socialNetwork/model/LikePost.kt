package com.api.socialNetwork.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class LikePost(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var likeId: Long? = null,

    @ManyToOne(cascade = [javax.persistence.CascadeType.PERSIST])
    @JoinColumn(name = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "postId")
    val postLiked: Post,
)