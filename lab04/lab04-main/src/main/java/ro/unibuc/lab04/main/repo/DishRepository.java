package ro.unibuc.lab04.main.repo;

import ro.unibuc.lab04.main.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {

    Dish add(Dish dish);

    List<Dish> findAll();

    Dish removeById(int id);

    Dish update(Dish dish);

    Optional<Dish> findById(int id);

}
