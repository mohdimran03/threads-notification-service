package com.example.threads_notification_service.kafka.consumers;

import com.example.threads_notification_service.NotificationService;
import com.example.threads_notification_service.kafka.events.NotificationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;
    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "notification-topic", groupId = "threads-notification-service")
    public void listen(String message) {
        try {
            logger.info("Message received: {}", message);
            // Parse the JSON string into a Notification object
            NotificationEvent notification = objectMapper.readValue(message, NotificationEvent.class);
            notificationService.createNotification(
                    notification.getUserId(),
                    notification.getType(),
                    notification.getContent()
            );
        } catch (Exception e) {
            logger.error("Failed to process message: {}", message, e);
        }
    }
}