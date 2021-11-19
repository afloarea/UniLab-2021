package ro.unibuc.lab06.main.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public record Game(Integer id, String title, double price, String publisher, Genre genre, LocalDateTime registrationDateTime) {

    public Game(String title, double price, String publisher, Genre genre) {
        this(null, title, price, publisher, genre);
    }

    public Game(Integer id, String title, double price, String publisher, Genre genre) {
        this(id, title, price, publisher, genre, LocalDateTime.now(ZoneOffset.UTC));
    }
}
