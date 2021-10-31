package ro.unibuc.lab03.main.services;

import org.springframework.stereotype.Service;
import ro.unibuc.lab03.main.dtos.DishDto;
import ro.unibuc.lab03.main.model.Dish;
import ro.unibuc.lab03.main.repositories.DishRepository;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class SimpleDishService implements DishService {

    private final DishRepository repo;

    public SimpleDishService(DishRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addDish(DishDto dishDto) {
        if (dishDto.getPrice() <= 0) {
            System.out.println("Invalid dish price. Ignoring...");
            return;
        }
        repo.add(new Dish(dishDto.getName(), dishDto.getPrice()));
    }

    @Override
    public Set<DishDto> getAllDishes() {
        final Set<DishDto> result = new LinkedHashSet<>();
        for (Dish dish : repo.findAll()) {
            result.add(new DishDto(dish.getName(), dish.getPrice()));
        }
        return Collections.unmodifiableSet(result);
    }
}
