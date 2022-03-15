package com.example.Exercise_Plants.controller;

import com.example.Exercise_Plants.entity.Delivery;
import com.example.Exercise_Plants.projections.RecipientAndPrice;
import com.example.Exercise_Plants.repository.DeliveryRepository;
import com.example.Exercise_Plants.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}


