package ro.unibuc.lab04.main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab04.main.dto.DishDto;
import ro.unibuc.lab04.main.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<DishDto> getDishes() {
        return dishService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DishDto addDish(@RequestBody DishDto dto) {
        return dishService.addDish(dto);
    }

    @GetMapping("/{dishId}")
    public ResponseEntity<DishDto> getById(@PathVariable("dishId") int dishId) {
        return ResponseEntity.of(dishService.getById(dishId));
    }

    @DeleteMapping("/{dishId}")
    public void deleteById(@PathVariable("dishId") int dishId) {
        dishService.deleteById(dishId);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<DishDto> updateDish(@RequestBody DishDto body, @PathVariable("dishId") int dishId) {
        return ResponseEntity.of(dishService.update(new DishDto(dishId, body.name(), body.price())));
    }

}
