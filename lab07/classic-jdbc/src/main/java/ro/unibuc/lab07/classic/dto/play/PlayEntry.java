package ro.unibuc.lab07.classic.dto.play;

import ro.unibuc.lab07.classic.model.Genre;

import java.time.Duration;

public record PlayEntry(String title, Genre genre, Duration duration) {
}
