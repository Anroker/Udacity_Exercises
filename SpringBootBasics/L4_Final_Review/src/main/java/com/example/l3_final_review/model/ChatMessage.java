package com.example.l3_final_review.model;

public class ChatMessage {
    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public ChatMessage setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ChatMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
