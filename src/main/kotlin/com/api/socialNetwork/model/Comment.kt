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
)