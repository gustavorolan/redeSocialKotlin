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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Notification

        return notificationId != null && notificationId == other.notificationId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(notificationId = $notificationId )"
    }
}