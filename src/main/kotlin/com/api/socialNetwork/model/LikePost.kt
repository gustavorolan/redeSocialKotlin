package com.api.socialNetwork.model

import org.hibernate.Hibernate
import javax.persistence.*

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as LikePost

        return likeId != null && likeId == other.likeId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(likeId = $likeId )"
    }
}