package com.udacity.jdnd.course1exercises.lesson2.exercise1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Pretend repository implementation
 * This class needs to be a Spring component as well, because our FoodService relies on it. We use
 * the @Repository annotation here to denote its function, but for this example @Component would work just
 * fine as well.
 */
@Repository
public class FoodRepository {
    private Map<MealTime, List<FoodData>> foodDatabase = new EnumMap<>(MealTime.class);

    public List<FoodData> getFood(MealTime mealTime) {
        return foodDatabase.getOrDefault(mealTime, new ArrayList<>());
    }

    public void addFood(MealTime mealTime, FoodData food) {
        foodDatabase.getOrDefault(mealTime, new ArrayList<>()).add(food);
    }
}
