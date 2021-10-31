package ro.unibuc.lab03.main.repositories;

import ro.unibuc.lab03.main.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish add(Dish dish);

    List<Dish> findAll();

}
