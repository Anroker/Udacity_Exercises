package com.udacity.jdnd.course1exercises.lesson2.exercise1;

/**
 * Food Service that performs business logic operations regarding food
 */
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Boolean isFoodAvailableAtMealTime(String foodName, MealTime mealTime) {
        return foodRepository.getFood(mealTime).stream()
                .filter(food -> food.getName().equals(foodName))
                .findFirst()
                .isPresent();
    }

    public void addFood(String foodName, Integer calories, MealTime mealTime) {
        foodRepository.addFood(mealTime, new FoodData(foodName, calories));
    }

    public FoodRepository getFoodRepository() {
        return foodRepository;
    }

    public void setFoodRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
}
