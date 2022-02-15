package com.example.l3_final_review;

import com.example.l3_final_review.service.MessageService;
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

}
