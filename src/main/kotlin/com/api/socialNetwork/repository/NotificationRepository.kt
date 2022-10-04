package com.api.socialNetwork.repository

import com.api.socialNetwork.model.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface NotificationRepository : JpaRepository<Notification, Long>
