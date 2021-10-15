package ro.unibuc.lab01.main.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab01.main.beans.model.Airplane;
import ro.unibuc.lab01.main.beans.model.Airport;

public class App {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("Context created");

        final Airplane plane = context.getBean("airplane", Airplane.class);
        final Airplane plane2 = (Airplane) context.getBean("airplane");

        System.out.println(plane);
        System.out.println(plane2);

        final var transport = context.getBean("transport-plane");
        System.out.println(transport);

        System.out.println("Airport:");
        final var airport = context.getBean(Airport.class);
        System.out.println(airport);

        plane.setType("luxury");
        System.out.println(plane);
        System.out.println(airport);

    }

}
