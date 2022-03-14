package com.example.Exercise_Plants.controller;

import com.example.Exercise_Plants.dto.PlantDTO;
import com.example.Exercise_Plants.entity.Plant;
import com.example.Exercise_Plants.jsonViews.ViewsJSON;
import com.example.Exercise_Plants.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    public PlantDTO getPlantDTO(String name) {

        return convertPlantToPlantDTO(plantService.getPlantByName(name));

    }

    @JsonView(ViewsJSON.Public.class)
    public Plant getFilteredPlant(String name) {

        return plantService.getPlantByName(name);

    }

    private PlantDTO convertPlantToPlantDTO(Plant plant) {

        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;

    }
}
