package ro.unibuc.lab02.main.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab02.main.aop.config.AopDemoConfig;
import ro.unibuc.lab02.main.aop.model.Person;
import ro.unibuc.lab02.main.aop.services.DrinkingService;
import ro.unibuc.lab02.main.aop.services.LuckService;
import ro.unibuc.lab02.main.aop.services.PersonSortingService;

public class AopDemo {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AopDemoConfig.class);

        final var drinkingService = context.getBean(DrinkingService.class);
        final var luckService = context.getBean(LuckService.class);
        final var sortingService = context.getBean(PersonSortingService.class);

        final var person1 = new Person("Ionuț", 29);
        final var person2 = new Person("Corina", 26);

        System.out.println("Corina is lucky?: " + luckService.isLucky(person2));
        System.out.println("Ionuț can drink?: " + drinkingService.canDrink(person1));
        System.out.println("Sorted: " + sortingService.sort(person1, person2));
    }

}
