package com.example.threads_notification_service.kafka;

import com.example.threads_notification_service.NotificationService;
import com.example.threads_notification_service.kafka.Events.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "notification-events", groupId = "notification-service-group")
    public void consume(NotificationEvent event) {
        notificationService.createNotification(event.getUserId(), event.getType(), event.getContent());
    }
}
