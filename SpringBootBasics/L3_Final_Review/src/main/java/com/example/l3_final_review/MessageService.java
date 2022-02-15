package com.example.l3_final_review;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String upperCase() {
        return this.message.toUpperCase();
    }

    public String lowerCase() {
        return this.message.toUpperCase();
    }
}
