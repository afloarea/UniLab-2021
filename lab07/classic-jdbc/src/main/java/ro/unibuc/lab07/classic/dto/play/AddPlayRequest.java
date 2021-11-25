package ro.unibuc.lab07.classic.dto.play;

import ro.unibuc.lab07.classic.model.Genre;

import java.time.Duration;

public record AddPlayRequest(String title, Genre genre, Duration duration) {
}
