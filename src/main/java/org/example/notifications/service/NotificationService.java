package org.example.notifications.service;

import org.example.notifications.dto.NotificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {
    Page<NotificationDto> getNotifications(Pageable pageable);

    NotificationDto notificate(NotificationDto notificationDto);

    void delete(Long id);
}
