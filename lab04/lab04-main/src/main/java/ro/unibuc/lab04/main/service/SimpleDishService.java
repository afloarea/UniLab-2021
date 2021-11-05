package ro.unibuc.lab04.main.service;

import org.springframework.stereotype.Service;
import ro.unibuc.lab04.main.dto.DishDto;
import ro.unibuc.lab04.main.model.Dish;
import ro.unibuc.lab04.main.repo.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleDishService implements DishService {

    private final DishRepository dishRepo;

    public SimpleDishService(DishRepository dishRepo) {
        this.dishRepo = dishRepo;
    }

    @Override
    public DishDto addDish(DishDto dish) {
        final var savedDish =  dishRepo.add(new Dish(dish.name(), dish.price()));
        return mapToDto(savedDish);
    }

    @Override
    public List<DishDto> getAll() {
        return dishRepo.findAll().stream()
                .map(SimpleDishService::mapToDto)
                .toList();
    }

    @Override
    public Optional<DishDto> getById(int dishId) {
        return dishRepo.findById(dishId).map(SimpleDishService::mapToDto);
    }

    @Override
    public Optional<DishDto> update(DishDto dish) {
        return Optional.ofNullable(dishRepo.update(mapToModel(dish))).map(SimpleDishService::mapToDto);
    }

    @Override
    public void deleteById(int dishId) {
        dishRepo.removeById(dishId);
    }

    private static DishDto mapToDto(Dish dish) {
        return new DishDto(dish.id(), dish.name(), dish.price());
    }

    private static Dish mapToModel(DishDto dto) {
        return new Dish(dto.id(), dto.name(), dto.price());
    }
}
