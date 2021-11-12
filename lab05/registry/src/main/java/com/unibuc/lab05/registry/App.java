package com.unibuc.lab05.registry;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        final var registry = new HashMap<String, int[]>();

        final Vertx vertx = Vertx.vertx();
        final Router router = Router.router(vertx);

        router.route().path("/registration")
                .handler(BodyHandler.create())
                .method(HttpMethod.POST)
                .handler(rc -> {
                    final var body = rc.getBodyAsJson();
                    registry.put(body.getString("name"), convert(body.getJsonArray("combination")));
                    rc.response()
                            .setStatusCode(204)
                            .end();
                });

        router.route().path("/query")
                .handler(BodyHandler.create())
                .method(HttpMethod.POST)
                .respond(rc -> {
                    final var body = rc.getBodyAsJsonArray();
                    final var combination = convert(body);
                    final List<String> match = registry.entrySet().stream()
                            .filter(entry -> Arrays.equals(combination, entry.getValue()))
                            .map(Map.Entry::getKey)
                            .toList();

                    return Future.succeededFuture(match);
                });

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8082);

    }

    private static int[] convert(JsonArray array) {
        return array.stream().map(Integer.class::cast).mapToInt(Integer::intValue).toArray();
    }

}
