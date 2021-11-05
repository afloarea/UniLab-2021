package ro.unibuc.lab04.main.service;

import ro.unibuc.lab04.main.dto.DishDto;

import java.util.List;
import java.util.Optional;

public interface DishService {

    DishDto addDish(DishDto dish);

    List<DishDto> getAll();

    Optional<DishDto> getById(int dishId);

    Optional<DishDto> update(DishDto dish);

    void deleteById(int dishId);

}
