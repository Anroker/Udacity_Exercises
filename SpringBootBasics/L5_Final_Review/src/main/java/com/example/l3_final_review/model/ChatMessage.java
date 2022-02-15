package com.example.l3_final_review.model;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messageText;

    public Integer getMessageId() {
        return messageId;
    }

    public ChatMessage setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ChatMessage setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMessage() {
        return messageText;
    }

    public ChatMessage setMessage(String message) {
        this.messageText = message;
        return this;
    }
}
