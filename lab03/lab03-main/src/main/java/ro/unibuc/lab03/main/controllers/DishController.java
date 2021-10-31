package ro.unibuc.lab03.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.unibuc.lab03.main.dtos.DishDto;
import ro.unibuc.lab03.main.services.DishService;

@Controller
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getDishList(Model model) {
        model.addAttribute("dishList", service.getAllDishes());
        return "index";
    }

    @PostMapping("/")
    public String addDish(@RequestParam("name") String name, @RequestParam("price") int price, Model model) {
        service.addDish(new DishDto(name, price));
        model.addAttribute("dishList", service.getAllDishes());
        return "index";
    }
}
