package com.example.threads_notification_service.services;

import com.example.threads_notification_service.models.Notification;
import com.example.threads_notification_service.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Service class for handling operations related to notifications.
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Creates a new notification and saves it to the repository.
     *
     * @param userId  the ID of the user for whom the notification is created
     * @param type    the type of the notification
     * @param content the content of the notification
     * @return the created Notification entity
     */
    public Notification createNotification(UUID userId, String type, String content) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setType(type);
        notification.setContent(content);
        notification.setCreatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    /**
     * Retrieves all notifications for a specific user.
     *
     * @param userId the ID of the user whose notifications are to be retrieved
     * @return a list of Notification entities for the specified user
     */
    public List<Notification> getNotificationsForUser(UUID userId) {
        return notificationRepository.findByUserId(userId);
    }

    /**
     * Deletes a notification by its ID.
     *
     * @param notificationId the ID of the notification to be deleted
     */
    public void deleteNotification(UUID notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}