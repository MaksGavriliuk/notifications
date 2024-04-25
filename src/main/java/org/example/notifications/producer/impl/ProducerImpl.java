package org.example.notifications.producer.impl;

import lombok.RequiredArgsConstructor;
import org.example.notifications.dto.NotificationDto;
import org.example.notifications.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerImpl implements Producer {

    @Value("${spring.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Override
    public void produce(NotificationDto notificationDto) {
        kafkaTemplate.send(topic, notificationDto);
    }

}
