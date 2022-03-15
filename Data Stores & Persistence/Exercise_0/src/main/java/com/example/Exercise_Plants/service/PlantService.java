package com.example.Exercise_Plants.service;

import com.example.Exercise_Plants.entity.Plant;
import com.example.Exercise_Plants.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlantByName(String name) {
        return new Plant();
    }

    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();
    }

    public Boolean delivered(Long id) {
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
