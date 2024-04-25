package org.example.notifications.producer;

import org.example.notifications.dto.NotificationDto;

public interface Producer {
    void produce(NotificationDto notificationDto);
}
