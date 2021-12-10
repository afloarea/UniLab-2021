package ro.unibuc.lab09.main.dto;

import ro.unibuc.lab09.main.model.Genre;

public record MovieEntry(long id, String title, Genre genre, double rating) {
}
