package com.api.socialNetwork.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Friendship(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var friendshipId: Long? = null,

    @ManyToOne(cascade = [javax.persistence.CascadeType.ALL])
    @JoinColumn(referencedColumnName = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(referencedColumnName = "userId")
    val userFriendShip: UserAccount,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val relation: Relation
)