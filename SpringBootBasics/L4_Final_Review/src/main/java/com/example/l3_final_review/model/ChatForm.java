package com.example.l3_final_review.model;

public class ChatForm {
    private String username;
    private String messageText;
    private String messageType;

    public String getUsername() {
        return username;
    }

    public ChatForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMessageText() {
        return messageText;
    }

    public ChatForm setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public ChatForm setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }
}
