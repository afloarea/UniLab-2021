package ro.unibuc.lab03.bonus.basic;

import ro.unibuc.lab03.bonus.basic.controllers.DishController;
import ro.unibuc.lab03.bonus.basic.extra.AppServer;
import ro.unibuc.lab03.bonus.basic.respositories.InMemoryDishRepository;
import ro.unibuc.lab03.bonus.basic.services.SimpleDishService;

public class App {

    public static void main(String[] args) {
        final var repository = new InMemoryDishRepository();
        final var service = new SimpleDishService(repository);
        final var controller = new DishController(service);

        new AppServer(controller).start();

    }

}
