package org.example.notifications.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private Long id;
    private String type;
    private String text;
    private LocalDateTime createdAt;
    private Boolean isRead;
    private String userMail;
}
