package com.example.threads_notification_service.kafka.consumers;

import com.example.threads_notification_service.services.NotificationService;
import com.example.threads_notification_service.kafka.events.NotificationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka consumer service for processing notification messages.
 */
@Service
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Listens for messages on the specified Kafka topic and processes them.
     *
     * @param message the message received from the Kafka topic
     */
    @KafkaListener(topics = "notification-topic", groupId = "threads-notification-service")
    public void listen(String message) {
        try {
            logger.info("Message received: {}", message);
            // Parse the JSON string into a NotificationEvent object
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