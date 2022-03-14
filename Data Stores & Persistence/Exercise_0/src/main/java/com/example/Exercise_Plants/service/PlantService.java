package com.example.Exercise_Plants.service;

import com.example.Exercise_Plants.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        return new Plant();
    }
}
