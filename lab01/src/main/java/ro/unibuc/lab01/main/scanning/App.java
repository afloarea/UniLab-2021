package ro.unibuc.lab01.main.scanning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab01.main.scanning.model.Fruit;
import ro.unibuc.lab01.main.scanning.model.FruitBag;

public class App {

    public static void main(String[] args) {

        final var context = new AnnotationConfigApplicationContext(Config.class);

        final var fruit = context.getBean(Fruit.class);

        System.out.println(fruit);

        final var bag = context.getBean(FruitBag.class);
        System.out.println(bag);

    }

}
