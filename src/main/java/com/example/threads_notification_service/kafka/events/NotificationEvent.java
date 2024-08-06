package com.example.threads_notification_service.kafka.events;

import java.util.UUID;

public class NotificationEvent {
    private UUID userId;
    private String type;
    private String content;
    private UUID tweetId;
    public UUID getUserId() {
        return userId;
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public void setTweetId(UUID tweetId) {
        this.tweetId = tweetId;
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
