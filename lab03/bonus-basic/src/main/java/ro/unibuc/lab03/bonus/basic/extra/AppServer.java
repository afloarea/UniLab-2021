package ro.unibuc.lab03.bonus.basic.extra;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import ro.unibuc.lab03.bonus.basic.controllers.DishController;
import ro.unibuc.lab03.bonus.basic.dto.DishDto;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public final class AppServer {
    private static final String NO_CONTENT_BODY = "<h1>404 Not Found</h1>No context found for request";

    private final HttpServer httpServer;
    private final DishController controller;

    public AppServer(DishController controller) {
        this.controller = controller;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(AppProperties.getServerPort()), 0);
            httpServer.setExecutor(null);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                httpServer.stop(1);
                System.out.println("Stopped server");
            }));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void start() {
        registerMappings();
        httpServer.start();
        System.out.println("Started http server on port " + httpServer.getAddress().getPort());
    }

    private void registerMappings() {
        httpServer.createContext("/", exchange -> {
            if (exchange.getRequestMethod().equalsIgnoreCase("get")) {
                handleGet(exchange);
                return;
            }
            if (exchange.getRequestMethod().equalsIgnoreCase("post")) {
                handlePost(exchange);
                return;
            }
            sendHtml(NO_CONTENT_BODY, exchange);
        });
    }

    private void handleGet(HttpExchange exchange) {
        final var model = new HashMap<String, Object>();
        final var page = controller.getDishes(model);
        final var template = readResource(page + ".html");

        final var content = model.values().stream().findFirst()
                .map(value -> {
                    @SuppressWarnings("unchecked")
                    final var mapped = (Set<DishDto>) value;
                    return mapped;
                })
                .stream()
                .flatMap(Set::stream)
                .map(DishDto.class::cast)
                .map(dish -> "<tr><td>%s</td><td>%s</td></tr>%n".formatted(dish.name(), dish.price()))
                .collect(Collectors.joining());

        sendHtml(template.replace("<table-content/>", content), exchange);
    }

    private void handlePost(HttpExchange exchange) {
        final String body;
        try (var input = exchange.getRequestBody()) {
            body = new String(input.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Failed to read request body");
            throw new IllegalStateException(e);
        }

        final var model = Arrays.stream(body.split("&"))
                .map(param -> param.split("="))
                .collect(Collectors.toMap(params -> params[0], params -> params[1]));

        controller.addDish(model);
        handleGet(exchange);
    }

    private void sendHtml(String html, HttpExchange exchange) {
        final var body = html.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/html");

        try (var out = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(200, body.length);
            out.write(body);
        } catch (IOException e) {
            System.out.println("Failed to write body");
            throw new IllegalStateException(e);
        }
    }

    private String readResource(String resourcePath) {
        final var input = AppServer.class.getResourceAsStream("/templates/" + resourcePath);
        try (input) {
            return new String(input.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Failed to read resource " + resourcePath);
            throw new IllegalStateException(e);
        }
    }

}
