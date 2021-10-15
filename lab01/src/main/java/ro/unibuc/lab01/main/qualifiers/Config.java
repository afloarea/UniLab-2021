package ro.unibuc.lab01.main.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ro.unibuc.lab01.main.qualifiers.model.Car;

@ComponentScan("ro.unibuc.lab01.main.qualifiers.model")
@Configuration
public class Config {

    @Primary
    @Bean
    public Car bigCar() {
        return new Car(3, 20_000, "Gigi");
    }

    @Qualifier("cool")
    @Bean
    public Car smallCar() {
        return new Car(1, 5_000, "Ionel");
    }

}
