package ro.unibuc.lab03.main.repositories;

import org.springframework.stereotype.Repository;
import ro.unibuc.lab03.main.model.Dish;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class InMemoryDishRepository implements DishRepository {

    private final List<Dish> dishList = new ArrayList<>();
    private int idCounter;

    @Override
    public Dish add(Dish dish) {
        final var storedDish = new Dish(++idCounter, dish.getName(), dish.getPrice());
        dishList.add(dish);
        return storedDish;
    }

    @Override
    public List<Dish> findAll() {
        return List.copyOf(dishList);
    }
}
