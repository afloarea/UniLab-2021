package ro.unibuc.lab03.bonus.basic.services;

import ro.unibuc.lab03.bonus.basic.dto.DishDto;
import ro.unibuc.lab03.bonus.basic.model.Dish;
import ro.unibuc.lab03.bonus.basic.respositories.DishRepository;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class SimpleDishService implements DishService {

    private final DishRepository repository;

    public SimpleDishService(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(DishDto dish) {
        if (dish.price() <= 0) {
            System.out.println("Warning: Invalid dish price provided. Ignoring...");
            return;
        }

        repository.add(new Dish(dish.name(), dish.price()));
    }

    @Override
    public Set<DishDto> getAllDishes() {
        final var orderedDishes =  repository.findAll().stream()
                .map(dishModel -> new DishDto(dishModel.dishName(), dishModel.price()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return Collections.unmodifiableSet(orderedDishes);
    }
}
