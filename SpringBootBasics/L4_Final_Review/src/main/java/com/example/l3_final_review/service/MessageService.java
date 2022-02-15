package com.example.l3_final_review.service;

import com.example.l3_final_review.model.ChatForm;
import com.example.l3_final_review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstructList");
        this.chatMessages = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public MessageService setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
        return this;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say" -> newMessage.setMessage(chatForm.getMessageText());
            case "Shout" -> newMessage.setMessage(chatForm.getMessageText().toUpperCase());
            case "Whisper" -> newMessage.setMessage(chatForm.getMessageText().toLowerCase());
        }

        this.chatMessages.add(newMessage);

    }
}
