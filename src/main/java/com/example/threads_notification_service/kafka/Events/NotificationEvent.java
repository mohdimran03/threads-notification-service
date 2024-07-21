package com.example.threads_notification_service.kafka.Events;

import java.util.UUID;

public class NotificationEvent {
    private UUID userId;
    private String type;
    private String content;
    private String event;

    public NotificationEvent() {}

    //setters and getters

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

