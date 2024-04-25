package org.example.notifications.mapper;

import org.example.notifications.dto.NotificationDto;
import org.example.notifications.entity.Notification;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {

    Notification toNotification(NotificationDto notificationDto);

    NotificationDto toNotificationDto(Notification notification);

}
