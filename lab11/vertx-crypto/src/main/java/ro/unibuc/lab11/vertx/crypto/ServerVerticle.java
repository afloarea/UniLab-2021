package ro.unibuc.lab11.vertx.crypto;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.ext.web.validation.BadRequestException;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.ValidationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class ServerVerticle extends AbstractVerticle {

    // run with 'mvn package exec:java'
    @Override
    public void start(Promise<Void> startPromise) {
        RouterBuilder.create(vertx, "/home/afloarea/Repositories/UniLab-2021/lab11/spec/crypto.yaml")
                .map(this::createRouter)
                .compose(router -> vertx.createHttpServer().requestHandler(router).listen(8080))
                .<Void>mapEmpty()
                .onComplete(startPromise);
    }

    private Router createRouter(RouterBuilder rb) {
        final var coinSet = new HashSet<String>();
        final var transactionMap = new HashMap<String, JsonObject>();

        rb.operation("add-coin")
                .handler(rc -> {
                    final var body = rc.getBodyAsJson();
                    System.out.println(body.encodePrettily());
                    coinSet.add(body.getString("id"));
                    rc.end();
                });

        rb.operation("get-transaction")
                .handler(rc -> {
                    final RequestParameters params = rc.get(ValidationHandler.REQUEST_CONTEXT_KEY);
                    final var transactionId = params.pathParameter("transactionId").getString();
                    final var transaction = transactionMap.get(transactionId);
                    if (transaction == null) {
                        rc.response().setStatusCode(404).end();
                        return;
                    }
                    if (!coinSet.contains(transaction.getString("coin"))) {
                        rc.response().setStatusCode(400).end();
                    }
                    rc.json(transaction);
                });

        rb.operation("add-transaction")
                .handler(rc -> {
                    final var body = rc.getBodyAsJson();
                    final var id = UUID.randomUUID().toString();

                    body.put("transactionId", id);
                    transactionMap.put(id, body);

                    rc.json(new JsonObject().put("transactionId", id));
                });

        return rb.createRouter()
                .errorHandler(400, rc -> {
                    if (rc.failure() instanceof BadRequestException badRequestEx) {
                        rc.json(badRequestEx.toJson());
                    }
                });
    }
}
