package com.api.socialNetwork.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Friendship(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var friendshipId: Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(referencedColumnName = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(referencedColumnName = "userId")
    val userFriendShip: UserAccount,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val relation: Relation
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Friendship

        return friendshipId != null && friendshipId == other.friendshipId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(friendshipId = $friendshipId )"
    }
}