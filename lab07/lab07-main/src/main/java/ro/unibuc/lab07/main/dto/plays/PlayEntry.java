package ro.unibuc.lab07.main.dto.plays;

import ro.unibuc.lab07.main.model.Genre;

import java.time.Duration;

public record PlayEntry(String title, Genre genre, Duration duration) {
}
