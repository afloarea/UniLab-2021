package com.unibuc.lab05.extractor;

import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static spark.Spark.*;

public class Extractor {
    private static final RandomGenerator RAND = RandomGenerator.of("Random");

    public static void main(String[] args) {
        port(8081);
        get("/extraction", ((request, response) -> {
            response.header("Content-Type", "application/json");
            return IntStream.generate(Extractor::generateRandomValue)
                    .limit(6)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"));
        }));

    }

    private static int generateRandomValue() {
        return RAND.nextInt(50) - 1;
    }

}
