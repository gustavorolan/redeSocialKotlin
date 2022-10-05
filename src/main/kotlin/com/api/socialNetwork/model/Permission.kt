package com.api.socialNetwork.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class Permission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var permissionId: Long? = null,

    val permissionName: String
)
