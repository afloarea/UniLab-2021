package ro.unibuc.lab01.main.qualifiers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab01.main.qualifiers.model.Garage;
import ro.unibuc.lab01.main.qualifiers.model.ParkingLot;

public class App {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        final var garage = context.getBean(Garage.class);

        System.out.println(garage);

        System.out.println(context.getBean(ParkingLot.class));

    }

}
