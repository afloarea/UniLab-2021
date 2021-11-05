package ro.unibuc.lab04.main.repo;

import org.springframework.stereotype.Repository;
import ro.unibuc.lab04.main.model.Dish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryDishRepository implements DishRepository {

    private final Map<Integer, Dish> dishById = new HashMap<>();
    private int idCounter = 0;

    @Override
    public Dish add(Dish dish) {
        final var storedDish = new Dish(++idCounter, dish.name(), dish.price());
        dishById.put(storedDish.id(), storedDish);
        return storedDish;
    }

    @Override
    public List<Dish> findAll() {
        return dishById.values().stream().toList();
    }

    @Override
    public Dish removeById(int id) {
        return dishById.remove(id);
    }

    @Override
    public Dish update(Dish dish) {
        return dishById.computeIfPresent(dish.id(), (k, v) -> dish);
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(dishById.get(id));
    }
}
