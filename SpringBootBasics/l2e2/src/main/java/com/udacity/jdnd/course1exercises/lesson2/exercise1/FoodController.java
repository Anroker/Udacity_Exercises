package com.udacity.jdnd.course1exercises.lesson2.exercise1;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for receiving requests.
 */
@RequestMapping("/food")
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String getHomePage(FoodForm foodForm, Model model) {
        foodService.addFood(foodForm.getFoodName(), foodForm.getCalories(), foodForm.getMealTime());
        return "foodAdded";
    }

}
