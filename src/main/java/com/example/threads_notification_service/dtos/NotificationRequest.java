package com.example.threads_notification_service.dtos;

import jakarta.persistence.Column;

import java.util.UUID;

public class NotificationRequest {
    @Column
    UUID userId;

    @Column
    String type;

    @Column
    String content;
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
