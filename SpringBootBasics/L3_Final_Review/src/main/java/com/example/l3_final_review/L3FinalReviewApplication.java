package com.example.l3_final_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class L3FinalReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(L3FinalReviewApplication.class, args);
    }

    @Bean
    public String message() {
        System.out.println("Creating message bean");
        return "Hello, Spring";
    }

    @Bean
    public String upperMessage(MessageService messageService) {
        System.out.println("Creating upperMessage bean");
        return messageService.upperCase();
    }

    @Bean
    public String lowerMessage(MessageService messageService) {
        System.out.println("Creating lowerMessage bean");
        return messageService.lowerCase();
    }
}
