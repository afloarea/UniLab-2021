package ro.unibuc.lab02.main.scopes.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab02.main.scopes.model.RentalRequest;
import ro.unibuc.lab02.main.scopes.services.config.ScopesDemoConfig;

import java.util.List;

public class ScopesDemo {
    private static final List<RentalRequest> REQUESTS = List.of(
            new RentalRequest("Ionel", 5000),
            new RentalRequest("Gigel", 500),
            new RentalRequest("Paul", 10_000)
    );

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ScopesDemoConfig.class);

        final var handlingService = context.getBean(RentalRequestHanldingService.class);
        final var inspectingService = context.getBean(RentalRequestInspectorService.class);

        System.out.println("Accepted request: " + handlingService.partitionRequests(REQUESTS).get(Boolean.TRUE));

        inspectingService.inspect(REQUESTS.get(1));

        System.out.println("SCOPED BEANS");

        context.getBean(RentalRequestHanldingService.class);
        context.getBean(RentalRequestHanldingService.class);
        context.getBean(RentalRequestHanldingService.class);

        context.getBean(RentalRequestInspectorService.class);
        context.getBean(RentalRequestInspectorService.class);
        context.getBean(RentalRequestInspectorService.class);

    }

}
