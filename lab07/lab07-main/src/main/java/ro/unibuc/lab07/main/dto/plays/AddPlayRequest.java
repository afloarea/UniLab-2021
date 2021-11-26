package ro.unibuc.lab07.main.dto.plays;

import ro.unibuc.lab07.main.model.Genre;

import java.time.Duration;

public record AddPlayRequest(String title, Genre genre, Duration duration) {
}
