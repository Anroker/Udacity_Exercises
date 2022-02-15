package com.udacity.jdnd.course1exercises.lesson2.exercise1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for receiving requests.
 * This class needs to be a Spring Component so that Spring can
 * automatically create instances of it to receive web requests. We use
 * the @Controller annotation variation of @Component for this purpose.
 */

@Controller
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String getHomePage(FoodForm foodForm, Model model) {
        foodService.addFood(foodForm.getFoodName(), foodForm.getCalories(), foodForm.getMealTime());
        return "foodAdded";
    }

}
