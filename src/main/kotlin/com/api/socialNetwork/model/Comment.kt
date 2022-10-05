package com.api.socialNetwork.model
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "postId")
    val postCommented: Post,

    @Column(nullable = false)
    val commentText: String? = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Comment

        return commentId != null && commentId == other.commentId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(commentId = $commentId )"
    }
}