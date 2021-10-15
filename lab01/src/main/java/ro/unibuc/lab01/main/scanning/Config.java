package ro.unibuc.lab01.main.scanning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan("ro.unibuc.lab01.main.scanning.model")
public class Config {
}
