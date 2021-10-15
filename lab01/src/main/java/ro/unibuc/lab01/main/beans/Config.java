package ro.unibuc.lab01.main.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.unibuc.lab01.main.beans.model.Airplane;
import ro.unibuc.lab01.main.beans.model.Airport;

@Configuration
public class Config {

    @Bean
    public Airplane airplane() {
        System.out.println("creating airplane");
        final var airplane = new Airplane();
        airplane.setType("cargo");
        airplane.setWeight(2);
        return airplane;
    }

    @Bean(name = "transport-plane")
    public Airplane transportPlane() {
        System.out.println("creating transport plane");
        final var transportPlane = new Airplane();
        transportPlane.setType("transport");
        transportPlane.setWeight(1);
        return transportPlane;
    }

    @Bean
    public Airport simpleAirport() {
        System.out.println("creating airport");
        final var airport = new Airport();
        airport.setName("Aeroport Craiova");
        airport.setAirplane(airplane());
        return airport;
    }

}
