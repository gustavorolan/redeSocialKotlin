package com.api.socialNetwork.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Notification(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var notificationId: Long? = null,

    @JsonIgnore
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "postId")
    val userAccount: UserAccount,

    @Column(nullable = false)
    val notification: String
)