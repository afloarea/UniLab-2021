package ro.unibuc.lab03.bonus.basic.controllers;

import ro.unibuc.lab03.bonus.basic.dto.DishDto;
import ro.unibuc.lab03.bonus.basic.services.DishService;

import java.util.Map;

public final class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    public String getDishes(Map<String, Object> model) {
        model.put("dishes", dishService.getAllDishes());
        return "index";
    }

    public void addDish(Map<String, String> model) {
        dishService.add(new DishDto(model.get("name"), Integer.parseInt(model.get("price"))));
    }

}
