package ro.unibuc.lab03.bonus.basic.services;

import ro.unibuc.lab03.bonus.basic.dto.DishDto;

import java.util.Set;

public interface DishService {

    void add(DishDto dish);

    Set<DishDto> getAllDishes();

}
