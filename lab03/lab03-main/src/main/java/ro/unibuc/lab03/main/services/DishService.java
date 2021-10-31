package ro.unibuc.lab03.main.services;

import ro.unibuc.lab03.main.dtos.DishDto;

import java.util.Set;

public interface DishService {

    void addDish(DishDto dishDto);

    Set<DishDto> getAllDishes();

}
