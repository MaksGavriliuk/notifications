package org.example.notifications.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.notifications.dto.NotificationDto;
import org.example.notifications.entity.Notification;
import org.example.notifications.mapper.NotificationMapper;
import org.example.notifications.producer.Producer;
import org.example.notifications.repository.NotificationRepository;
import org.example.notifications.service.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final Producer producer;

    @Override
    public Page<NotificationDto> getNotifications(Pageable pageable) {
        Page<Notification> notifications = notificationRepository.findAll(pageable);
        notifications.forEach(notificationDto -> notificationDto.setIsRead(Boolean.TRUE));
        notificationRepository.saveAll(notifications);
        return notifications.map(notificationMapper::toNotificationDto);
    }

    @Override
    public NotificationDto notificate(NotificationDto notificationDto) {
        Notification notification = notificationRepository.save(notificationMapper.toNotification(notificationDto));
        NotificationDto mappedDto = notificationMapper.toNotificationDto(notification);
        producer.produce(mappedDto);
        return mappedDto;
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

}
