package ro.unibuc.lab09.main.dto;

import ro.unibuc.lab09.main.model.Genre;

public record AddMovieRequest(String title, Genre genre, double rating) {
}
