package ro.unibuc.lab03.bonus.basic.extra;

import java.io.IOException;
import java.util.Properties;

public final class AppProperties {

    private static final Properties PROPS = new Properties();

    static {
        try (var input = AppProperties.class.getResourceAsStream("/application.properties")) {
            PROPS.load(input);
        } catch (IOException e) {
            System.out.println("Failed to load application properties");
            throw new IllegalStateException(e);
        }
    }

    public static int getServerPort() {
        return Integer.parseInt(PROPS.getProperty("server.port", "8080"));
    }

    private AppProperties() {
    }
}
