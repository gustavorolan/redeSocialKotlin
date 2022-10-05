package com.api.socialNetwork.model

import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
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
)
