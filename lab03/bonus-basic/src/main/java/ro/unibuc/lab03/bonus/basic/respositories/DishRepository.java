package ro.unibuc.lab03.bonus.basic.respositories;

import ro.unibuc.lab03.bonus.basic.model.Dish;

import java.util.List;

public interface DishRepository {

    List<Dish> findAll();

    Dish add(Dish dish);

}
