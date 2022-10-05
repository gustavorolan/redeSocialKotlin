package com.api.socialNetwork.model

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Permission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var permissionId: Long? = null,

    val permissionName: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Permission

        return permissionId != null && permissionId == other.permissionId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(permissionId = $permissionId )"
    }
}