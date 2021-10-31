package ro.unibuc.lab03.bonus.basic.respositories;

import ro.unibuc.lab03.bonus.basic.model.Dish;

import java.util.ArrayList;
import java.util.List;

public final class InMemoryDishRepository implements DishRepository {

    private int idCounter = 0;
    private final List<Dish> dishList = new ArrayList<>();

    @Override
    public List<Dish> findAll() {
        return List.copyOf(dishList);
    }

    @Override
    public Dish add(Dish dish) {
        final var savedDish = new Dish(++idCounter, dish.dishName(), dish.price());
        dishList.add(savedDish);
        return savedDish;
    }
}
